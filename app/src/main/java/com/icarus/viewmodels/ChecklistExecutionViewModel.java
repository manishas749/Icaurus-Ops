package com.icarus.viewmodels;

import android.app.Application;
import android.text.TextUtils;

import com.icarus.R;
import com.icarus.adapters.FileRequiredAdapter;
import com.icarus.base.BaseApplication;
import com.icarus.base.BaseViewModel;
import com.icarus.constants.Constants;
import com.icarus.entities.AssignedStepFileResourceEntity;
import com.icarus.entities.ResourceEntity;
import com.icarus.enums.AttributeType;
import com.icarus.enums.ChecklistElementType;
import com.icarus.enums.ChecklistExecutionStatus;
import com.icarus.enums.LogTableActions;
import com.icarus.listeners.OnDownloadListener;
import com.icarus.models.AttachmentItems;
import com.icarus.models.CheckListPPItems;
import com.icarus.models.CheckListStepAttributeItems;
import com.icarus.models.ChecklistDetailItems;
import com.icarus.models.ChecklistIDetailtems;
import com.icarus.models.NcwHazardsItems;
import com.icarus.models.ParentDetailItem;
import com.icarus.models.QRAttributeScanItem;
import com.icarus.models.ResourceLinkItems;
import com.icarus.models.SelectedFile;
import com.icarus.models.UserItems;
import com.icarus.models.UserMinimal;
import com.icarus.navigators.ChecklistExecutionNavigator;
import com.icarus.navigators.QRCodeScanNavigator;
import com.icarus.repositories.CheckListExecuteRepository;
import com.icarus.repositories.UserSuggestionRepository;
import com.icarus.util.AppUtility;
import com.icarus.util.FileUtils;
import com.icarus.util.QRScanAttribute;
import com.icarus.widget.viewmodel.GalleryViewModel;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.databinding.ObservableField;
import androidx.databinding.ObservableList;
import androidx.annotation.NonNull;

import android.text.TextUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Monika Rana on 1/25/2019.
 */

public class ChecklistExecutionViewModel extends BaseViewModel<ChecklistExecutionNavigator> {
    private int checklistId;
    private String checkListUUID;
    private int sortOrder = 0;
    private ChecklistDetailItems checklistElementDetail;
    public ObservableField<String> toolbarTitle = new ObservableField<>();
    private CheckListExecuteRepository checkListExecuteRepository;
    public ObservableField<String> qaUserNameError = new ObservableField<>();
    public ObservableField<String> qaPasswordError = new ObservableField<>();
    private boolean isButtonEnabled = true;
    public List<CheckListStepAttributeItems> attributeItemsList;
    private List<ResourceLinkItems> resourceLinkList;
    private List<ResourceEntity> resourceFilesList;
    private List<CheckListPPItems> checkListPPItemsList;
    private List<NcwHazardsItems> cheNcwHazardsItemsList;
    private int selectedTab;
    private boolean isSequential, isExecuted, isReference, isButtonVisible, isStepExecuted;
    private ResourceEntity resource;
    private String btnText = "";
    private ChecklistIDetailtems checklistIDetailtems;
    //booleans for fab icon
    public boolean isOpen, isReferenceAvailable, isDeferAvailable, isSkipAvailable;
    private GalleryViewModel galleryViewModel;
    private UserSuggestionRepository userSuggestionRepository;
    //booleans for orientation change
    private ReasonPopUpViewModel reasonPopUpViewModel;
    private List<FileRequiredAdapter> fileRequiredAdapter;
    private QRScanAttribute qrScanAttribute;

    public ChecklistExecutionViewModel(@NonNull Application application) {
        super(application);
    }

    public void fetchData(int offset, int checklistId, String checklistUUId, int selectedTab) {
        this.sortOrder = offset;
        this.checklistId = checklistId;
        this.checkListUUID = checklistUUId;
        this.selectedTab = selectedTab;
        checkListExecuteRepository = new CheckListExecuteRepository(getApplication());
        getExecutionData(true, true);
    }

    public void fetchNextData(boolean isNext) {
        fileRequiredAdapter = null;
        qrScanAttribute = null;
        isOpen = false;
        getNavigator().openMenu(isOpen);
        if (!isNext || !isSequential || isExecuted || checklistElementDetail.isDeferred()
                || checklistElementDetail.isSkipped()
                || checklistElementDetail.isParentStep())
            showStepElement(isNext);
        else {
            if (checklistElementDetail.isStepProcedureDataStep())
                getNavigator().showErrorMessage(getApplication().getString(R.string.validate_sequential_checklist));
            else
                getNavigator().showErrorMessage(getApplication().getString(R.string.execte_sequential_element));
        }
    }


    /**
     * Opens corresponding Step Element and checks which element is to be displayed
     *
     * @param isNext detects if next or previous element is to be shown
     */
    private void showStepElement(boolean isNext) {
        if (checklistElementDetail != null) {
            sortOrder = checklistElementDetail.getSortOrder();
            if (attributeItemsList != null)
                attributeItemsList.clear();
            getExecutionData(isNext, false);
        }
    }


    public ChecklistDetailItems getChecklistElementDetail() {
        return checklistElementDetail;
    }

    /**
     *
     */
    private void getExecutionData(boolean isNext, boolean isCurrent) {
        ChecklistDetailItems elementDetail = null;
        if (selectedTab == 0) {//is All checklist tab selected
            if (isCurrent)
                elementDetail = checkListExecuteRepository.getChecklistElement(getSortOrder(), checkListUUID);
            else if (isNext)
                elementDetail = checkListExecuteRepository.getChecklistNextElement(sortOrder, checkListUUID, checklistId);
            else
                elementDetail = checkListExecuteRepository.getChecklistPreviousElement(sortOrder, checkListUUID, checklistId);
        } else if (selectedTab == 2)//For Deferred tab selected
            if (isCurrent)
                elementDetail = checkListExecuteRepository.getChecklistDefferedElement(getSortOrder(), checklistId, checkListUUID);
            else if (isNext)
                elementDetail = checkListExecuteRepository.getChecklistNextDefferedElement(sortOrder, checklistId, checkListUUID);
            else
                elementDetail = checkListExecuteRepository.getChecklistPreviousDefferedElement(sortOrder, checklistId, checkListUUID);
        else if (selectedTab == 1) // For Skipped tab selected
            if (isCurrent)
                elementDetail = checkListExecuteRepository.getChecklistSkippedElement(getSortOrder(), checklistId, checkListUUID);
            else if (isNext)
                elementDetail = checkListExecuteRepository.getChecklistNextSkippedElement(sortOrder, checklistId, checkListUUID);
            else
                elementDetail = checkListExecuteRepository.getChecklistPreviousSkipedElement(sortOrder, checklistId, checkListUUID);

        //return to checklist screen if end of list
        if (elementDetail == null) {
            getNavigator().checklistFinished();
            return;
        }

        //Save selected checklist element
        checklistElementDetail = elementDetail;

        //Check checklist type and open fragment accordingly
        if (elementDetail.isDecision())
            getNavigator().openDecisionExecution(isNext);
        else if (elementDetail.isStepProcedureDataStep())
            getNavigator().openPagerFragment(isNext);
        else if (elementDetail.isResource())
            getNavigator().openEmbeddedImageFragment(isNext);
        else
            getNavigator().openNCWExecution(isNext);
    }

    private int getSortOrder() {
        sortOrder = checkListExecuteRepository.getValidSortOrder(sortOrder, checklistId);
        return sortOrder;
    }

    public void getData(ChecklistDetailItems elementDetail) {
        //Getting attributes for this step
        boolean isCompleted = false;

        if (elementDetail == null)
            return;

        if (elementDetail.isNCWTR() && elementDetail.isSkipped() && getSelectedTab() == 0) {
            setBtnText(getApplication().getString(R.string.skipped));
            isButtonEnabled = false;
            isCompleted = true;
            setExecuted(true);
            isButtonVisible = true;
        } else if (elementDetail.isNCWTR() && elementDetail.isDeferred() && getSelectedTab() == 0) {
            setBtnText(getApplication().getString(R.string.deferred));
            isButtonEnabled = false;
            isCompleted = true;
            setExecuted(true);
            isButtonVisible = true;
        } else if (elementDetail.isNCW()) {
            if (elementDetail.checkElementIfExecuted()) {
                setBtnText(getApplication().getString(R.string.acknowledged));
                isButtonEnabled = false;
                isCompleted = true;
                setExecuted(true);
            } else {
                setBtnText(getApplication().getString(R.string.acknowledge));
                isButtonEnabled = true;
                setExecuted(false);
            }
            isButtonVisible = true;
           /* A note, caution or warning may be independent or be a child of decision point or be a child of step/data step/procedure (collectively known as a step).
                    If either of them is a child element of a step, then they need to be acknowledged first before a user can execute the step.*/
        } else if (elementDetail.getItemTypeId() == ChecklistElementType.TEXT.getValue()) {
            if (elementDetail.checkElementIfExecuted()) {
                setBtnText(getApplication().getString(R.string.read));
                isButtonEnabled = false;
                setExecuted(true);
                isCompleted = true;
            } else {
                setBtnText(getApplication().getString(R.string.next));
                isButtonEnabled = true;
                setExecuted(false);
            }
            isButtonVisible = true;
        } else if (elementDetail.getItemTypeId() == ChecklistElementType.RESOURCE.getValue()) {
            if (elementDetail.checkElementIfExecuted()) {
                setBtnText(getApplication().getString(R.string.viewed));
                isButtonEnabled = false;
                setExecuted(true);
                isCompleted = true;

            } else {
                setBtnText(getApplication().getString(R.string.next));
                isButtonEnabled = true;
                setExecuted(false);
            }
            resource = checkListExecuteRepository.getChecklistResource(elementDetail.getItemId());
            isButtonVisible = true;
        } else
            isButtonVisible = false;

        getAttributes(String.valueOf(elementDetail.getItemId()), isCompleted, elementDetail.getElementId());

        getPPEList(elementDetail.getItemId(), elementDetail.getItemTypeId());
        getHazardList(elementDetail.getItemId(), elementDetail.getItemTypeId());

        if (elementDetail.isStepProcedureDataStep())
            getReferenceList(elementDetail.getItemId());

        toolbarTitle.set(elementDetail.getSequenceNo());

    }

    public void checkStepExecuted() {
        if (checklistElementDetail.getItemTypeId() == ChecklistElementType.PROCEDURE.getValue() || checklistElementDetail.getItemTypeId() == ChecklistElementType.STEP.getValue() || checklistElementDetail.getItemTypeId() == ChecklistElementType.DATA_STEP.getValue()) {
            if (checklistElementDetail.getStatus() != null && (checklistElementDetail.getStatus() == ChecklistExecutionStatus.ACKNOWLEDGE.getValue() || checklistElementDetail.getStatus() == ChecklistExecutionStatus.SKIPPED.getValue() || checklistElementDetail.getStatus() == ChecklistExecutionStatus.DEFERRED.getValue())) {
                isButtonEnabled = false;
                setStepExecuted(true);
                setExecuted(true);
            } else {
                isButtonEnabled = true;
                setStepExecuted(false);
                setExecuted(false);
            }
        }
    }

    private void getAttributes(String itemId, boolean isCompleted, Integer elementId) {
        if (checklistElementDetail.isStepProcedureDataStep())
            attributeItemsList = checkListExecuteRepository.getStepAttributes(itemId, elementId, checkListUUID);
        if (attributeItemsList != null && attributeItemsList.size() > 0) {
            //isNextAttribute = true;
            //If element is completed than submit button will be disabled
            if (!isCompleted) {
                isButtonVisible = true;
                setBtnText(getApplication().getString(R.string.record_details));
            }
        } else {
            //   isNextAttribute = false;
        }
        //attributeListOffset = -1;
    }

    private void getPPEList(Integer checkListStepId, Integer itemTypeId) {
        if (checklistElementDetail.isStepProcedureDataStep())
            checkListPPItemsList = checkListExecuteRepository.getCheckListPP(checkListStepId);
    }

    private void getHazardList(Integer itemId, int itemTypeId) {
        if (itemTypeId == ChecklistElementType.NOTE.getValue() || itemTypeId == ChecklistElementType.CAUTION.getValue() || itemTypeId == ChecklistElementType.WARNING.getValue())
            cheNcwHazardsItemsList = checkListExecuteRepository.getNcwHazards(itemId, itemTypeId);
    }

    public List<ChecklistDetailItems> getStepEmbeddedImages(Integer parentId) {
        return checkListExecuteRepository.getStepEmbedded(checkListUUID, checklistId, parentId);
    }

    public boolean ifStepEmbeddedImagesExecuted(List<ChecklistDetailItems> checklistDetailItemsList) {
        for (int i = 0; i < checklistDetailItemsList.size(); i++) {
            if (!checklistDetailItemsList.get(i).checkElementIfExecuted())
                return false;
        }
        return true;
    }

    public void setFileRequiredItem(SelectedFile selectedFile, FileRequiredAdapter fileRequiredAdapter) {
        fileRequiredAdapter.setItem(selectedFile);
    }

    public void setFileRequiredAdapterInList(FileRequiredAdapter fileRequiredAdapter, int position) {
        this.fileRequiredAdapter.set(position, fileRequiredAdapter);
    }

    public void setSingleFileRequiredItem(SelectedFile selectedFile, FileRequiredAdapter fileRequiredAdapter) {
        fileRequiredAdapter.setSingleItem(selectedFile);
    }

    public FileRequiredAdapter getFileRequiredAdapter(int position) {
        return fileRequiredAdapter.get(position);
    }

    public int getFileAdapterPosition() {
        if (fileRequiredAdapter == null)
            fileRequiredAdapter = new ArrayList<>();
        fileRequiredAdapter.add(new FileRequiredAdapter(this));
        return fileRequiredAdapter.size() - 1;
    }

    private void getReferenceList(Integer checkListStepId) {
        resourceLinkList = checkListExecuteRepository.getResourcesLinks(checkListStepId);
        resourceFilesList = checkListExecuteRepository.getChecklistReferences(checkListStepId);
        if ((resourceFilesList != null && resourceFilesList.size() > 0) || (resourceLinkList != null && resourceLinkList.size() > 0))
            isReference = true;
        else
            isReference = false;
    }


    public void showReference() {
        getNavigator().showReferenceDialog(resourceFilesList, resourceLinkList, getNavigator());
    }

    public void deleteSelectedFile(SelectedFile file, FileRequiredAdapter fileRequiredAdapter) {
        fileRequiredAdapter.setDeleteFile(file);
        fileRequiredAdapter.removeItem(file);
    }

    public void openFile(SelectedFile file) {
        getNavigator().openAttachFile(file);
    }

    public List<CheckListPPItems> getCheckListPPItemsList() {
        return checkListPPItemsList;
    }

    public List<NcwHazardsItems> getCheNcwHazardsItemsList() {
        return cheNcwHazardsItemsList;
    }

    public void executeStep(Integer status, Integer action, FileRequiredAdapter fileRequiredAdapter) {
        checkListExecuteRepository.executeStep(checkListUUID, checklistElementDetail.getItemId(), checklistElementDetail.getElementId(), status, checklistId, checklistElementDetail.getElementId(), action, checklistElementDetail.getDescription(), "");
        if (fileRequiredAdapter != null && fileRequiredAdapter.getItems() != null)
            fileRequiredAdapter.getItems().clear();
    }

    public void executeStep(Integer status, Integer action) {
        checkListExecuteRepository.executeStep(checkListUUID, checklistElementDetail.getItemId(), checklistElementDetail.getElementId(), status, checklistId, checklistElementDetail.getElementId(), action, checklistElementDetail.getDescription(), "");
    }

    public void executeStepFileResources(int position, FileRequiredAdapter fileRequiredAdapter) {
        attributeItemsList.get(position).setAttributeValue("File");
        if (fileRequiredAdapter != null) {
            //Get list of deleted file if attribute is getting edited and set isDeleted 1 in db
            ArrayList<SelectedFile> deletedFileList = fileRequiredAdapter.getDeletedFileList();
            if (deletedFileList != null)
                for (int i = 0; i < deletedFileList.size(); i++) {
                    SelectedFile file = deletedFileList.get(i);
                    if (!TextUtils.isEmpty(file.getFileUUID()))
                        checkListExecuteRepository.removeFileFromStepAttribute(file.getFileUUID());
                }

            //Save attribute files in the database in AssignedStepFileResourceEntity table and
            //assignedStepAttributesEntity table
            for (int i = 0; i < fileRequiredAdapter.getItemCount(); i++) {
                if (!fileRequiredAdapter.getItems().get(i).isExecuted()) {
                    String uuid = checkListExecuteRepository.getIfFileAlreadyExists(checkListUUID,
                            checklistElementDetail.getItemId(),
                            fileRequiredAdapter.getItems().get(i).getFileMd5Checksum(),
                            attributeItemsList.get(position).getId());
                    fileRequiredAdapter.getItems().get(i).setExecuted(true);
                    if (uuid == null || uuid.length() == 0)
                        uuid = AppUtility.Companion.getUuid();
                    checkListExecuteRepository.executeStepFileResources(checkListUUID, checklistElementDetail.getItemId(), checklistElementDetail.getElementId(), fileRequiredAdapter.getItems().get(i).getFileMd5Checksum(), fileRequiredAdapter.getItems().get(i).getContentType(), fileRequiredAdapter.getItems().get(i).getFileName(), checklistElementDetail.getItemTypeId(), fileRequiredAdapter.getItems().get(i).getDisplayName(), checklistId, LogTableActions.FILE.getValue(), attributeItemsList.get(position).getLabel(), uuid);
                    checkListExecuteRepository.executeStepAttribute(checkListUUID, checklistElementDetail.getItemId(), checklistElementDetail.getElementId(), uuid, fileRequiredAdapter.getItems().get(i).getFileUUID(), attributeItemsList.get(position).getId(), checklistId, LogTableActions.FILE.getValue(), attributeItemsList.get(position).getLabel());
                }
            }
        }
    }

    public void executeStepAttribute(String selectedValue, String logValue, Integer action, int position) {
        attributeItemsList.get(position).setAttributeValue(selectedValue);
        checkListExecuteRepository.executeStepAttribute(checkListUUID, checklistElementDetail.getItemId(), checklistElementDetail.getElementId(), selectedValue, attributeItemsList.get(position).getItemUuid(), attributeItemsList.get(position).getId(), checklistId, action, attributeItemsList.get(position).getLabel(), logValue);
    }

    public void executeStepAttribute(String selectedValue, Integer action, int position) {
        attributeItemsList.get(position).setAttributeValue(selectedValue);
        checkListExecuteRepository.executeStepAttribute(checkListUUID, checklistElementDetail.getItemId(), checklistElementDetail.getElementId(), selectedValue, attributeItemsList.get(position).getItemUuid(), attributeItemsList.get(position).getId(), checklistId, action, attributeItemsList.get(position).getLabel());
    }

    public void executeStepAttribute(String selectedValue, Integer action, String userName, int position) {
        attributeItemsList.get(position).setAttributeValue(selectedValue);
        checkListExecuteRepository.executeStepAttribute(checkListUUID, checklistElementDetail.getItemId(), checklistElementDetail.getElementId(), selectedValue, attributeItemsList.get(position).getItemUuid(), attributeItemsList.get(position).getId(), checklistId, action, attributeItemsList.get(position).getLabel(), userName, attributeItemsList.get(position).getStepAttributeUuid());
    }

    public void executeDecisionPoints(Integer status) {
        checkListExecuteRepository.executeDecisionPoints(checkListUUID, checklistElementDetail.getElementId(), status, checklistElementDetail.getDescription(), checklistId, checklistElementDetail.getItemId(), "");
    }

    public void executeNCW(Integer acknowledge) {
        checkListExecuteRepository.executeNCW(checkListUUID, checklistElementDetail.getItemTypeId(), checklistElementDetail.getElementId(), checklistElementDetail.getItemId(), acknowledge, checklistId, checklistElementDetail.getDescription(), "");
    }

    public void executeImage(Integer elementId, String elementUuid, String elementDesc) {
        checkListExecuteRepository.executeImageText(checkListUUID, checklistId, elementId, LogTableActions.IMAGE.getValue(), elementUuid, elementDesc, "");
    }

    public void executeImageText(Integer action) {
        checkListExecuteRepository.executeImageText(checkListUUID, checklistId, checklistElementDetail.getElementId(),
                action, checklistElementDetail.getItemUuid(), checklistElementDetail.getDescription(), "");
    }

    public List<UserItems> getUserList(String usersRoles) {
        Integer departmentId = getChecklistIDetailtems().getDepartmentId();

        return checkListExecuteRepository.getUsersByGroupId(departmentId, usersRoles);
    }

    public void skipDefferElement(Integer status, String reason, Integer action) {
        Integer elementId = checklistElementDetail.getElementId();
        Integer itemId = checklistElementDetail.getItemId();
        String description = checklistElementDetail.getDescription();

        if (checklistElementDetail.isNCW() && !checklistElementDetail.isParentStep())
            checkListExecuteRepository.executeNCW(checkListUUID,
                    checklistElementDetail.getItemTypeId(), checklistElementDetail.getElementId(),
                    checklistElementDetail.getItemId(), status, checklistId,
                    checklistElementDetail.getDescription(), reason);
        else if (checklistElementDetail.isDecision() && !checklistElementDetail.isParentStep()) {
            checkListExecuteRepository.executeDecisionPoints(checkListUUID,
                    checklistElementDetail.getElementId(),
                    status,
                    checklistElementDetail.getDescription(),
                    checklistId,
                    checklistElementDetail.getItemId(),
                    reason);
        } else if ((checklistElementDetail.isText() || checklistElementDetail.isResource()) && !checklistElementDetail.isParentStep()) {
            checkListExecuteRepository.executeImageText(checkListUUID,
                    checklistId,
                    checklistElementDetail.getElementId(),
                    status,
                    checklistElementDetail.getItemUuid(),
                    checklistElementDetail.getDescription(),
                    reason);
        } else {
            if (checklistElementDetail.isParentStep()) {
                ParentDetailItem parent = checkListExecuteRepository.getParentDetail(checklistElementDetail.getSkipDefferId(), checkListUUID);
                elementId = parent.getElementId();
                itemId = parent.getItemId();
                description = parent.getDescription();
            }
            checkListExecuteRepository.executeStep(checkListUUID, itemId, elementId, status, checklistId, elementId, action, description, reason);
        }
        //Open next element if skipped and executed true as next element is to be open
        setExecuted(true);
        fetchNextData(true);
    }

    public boolean isChildExecuted(Integer itemID) {
        return checkListExecuteRepository.isChildrenExecuted(checkListUUID, itemID);
    }

    public boolean isAttributesExecuted() {
        boolean isExecuted = true;
        for (int i = 0; i < attributeItemsList.size(); i++) {
            if (!attributeItemsList.get(i).getType().equalsIgnoreCase(AttributeType.QR.toString())
                    && TextUtils.isEmpty(attributeItemsList.get(i).getAttributeValue())) {
                isExecuted = false;
            }
        }
        if (isExecuted && qrScanAttribute != null)
            isExecuted = !qrScanAttribute.checkIfQRScanPending();
        return isExecuted;
    }

    public boolean isAnyDecisionChildExecuted(Integer elementId, Integer sortOrder) {
        return checkListExecuteRepository.isAnyDecisionChildExecuted(checkListUUID, isSequential, elementId, sortOrder);
    }

    public int getChecklistId() {
        return checklistId;
    }

    public boolean isSequential() {
        return isSequential;
    }

    public void setSequential(boolean sequential) {
        isSequential = sequential;
    }

    public boolean isExecuted() {
        return isExecuted;
    }

    public void setExecuted(boolean executed) {
        isExecuted = executed;
    }

    public void pauseChecklist(String reason) {
        checkListExecuteRepository.pauseAssignedCheckList(checkListUUID, reason, checklistId);
    }

    public UserMinimal verifyQA(String username, String password, String userRoles) {
        qaUserNameError.set(null);
        qaPasswordError.set(null);
        UserMinimal userMinimal = new UserMinimal();
        if (username.isEmpty())
            qaUserNameError.set(getApplication().getString(R.string.error_field_required));
        else if (password.isEmpty())
            qaPasswordError.set(getApplication().getString(R.string.error_field_required));
        else {
            userMinimal = checkListExecuteRepository.validateQA(username, password, userRoles, getChecklistIDetailtems().getDepartmentId());
        }
        return userMinimal;
    }

    public void onResourceClick() {
        if (getResource() != null)
            getNavigator().openResource(checklistElementDetail);
    }

    public void onEmbeddedImageClick(ChecklistDetailItems item) {
        if (item != null)
            getNavigator().openEmbeddedImage(item);
    }

    public ResourceEntity getResource() {
        return resource;
    }

    public void setResource(ResourceEntity resource) {
        this.resource = resource;
    }

    public boolean isButtonEnabled() {
        return isButtonEnabled;
    }

    public boolean isReference() {
        return isReference;
    }

    public boolean isButtonVisible() {
        return isButtonVisible;
    }

    public void setButtonVisible(boolean buttonVisible) {
        isButtonVisible = buttonVisible;
    }

    public String getBtnText() {
        return btnText;
    }

    public void setBtnText(String btnText) {
        this.btnText = btnText;
    }

    public void setStepExecuted(boolean stepExecuted) {
        isStepExecuted = stepExecuted;
    }

    public boolean isStepExecuted() {
        return isStepExecuted;
    }

    public int getSelectedTab() {
        return selectedTab;
    }

    public void setSelectedTab(int position) {
        selectedTab = position;
    }

    public void downloadFile(ResourceEntity entity, OnDownloadListener onDownloadListener) {
        checkListExecuteRepository.downloadFile(entity, onDownloadListener);
    }

    public void downloadAttachedFileRequired(SelectedFile selectedFile, OnDownloadListener onDownloadListener) {
        checkListExecuteRepository.downloadAttachedTemplateFile(selectedFile, onDownloadListener);
    }

    public ChecklistIDetailtems getChecklistIDetailtems() {
        if (checklistIDetailtems == null)
            checklistIDetailtems = checkListExecuteRepository.getChecklistDetail(checkListUUID);
        return checklistIDetailtems;
    }

    public List<AssignedStepFileResourceEntity> getAttributeFiles(Integer position, Integer elementId) {
        return checkListExecuteRepository.getAttributeFiles(attributeItemsList.get(position).getId(), checkListUUID, elementId);
    }

    public void updateDownloadResource(ResourceEntity resourceEntity, File fileDestinationFolder) {
        checkListExecuteRepository.update(resourceEntity, fileDestinationFolder);
    }

    //handle fab icon click
    public GalleryViewModel getGalleryViewModel() {
        if (galleryViewModel == null) {
            File fileDestinationFolder = FileUtils.getSuggestionAttachmentsDir();
            galleryViewModel = new GalleryViewModel(getApplication(), fileDestinationFolder);
        }
        return galleryViewModel;
    }

    public void setGalleryViewModel(GalleryViewModel galleryViewModel) {
        this.galleryViewModel = galleryViewModel;
    }

    public void addSuggestion(String reason, ObservableList<AttachmentItems> listAttachment) {
        if (userSuggestionRepository == null)
            userSuggestionRepository = new UserSuggestionRepository(getApplication());
        userSuggestionRepository.addUserSuggestion(checkListUUID, checklistId, getChecklistElementDetail().getElementId(), reason, listAttachment);
    }

    public void showMenu() {
        isOpen = !isOpen;
        getNavigator().openMenu(isOpen);
    }

    public void skipElement() {
        getNavigator().skip();
    }

    public void deferElement() {
        getNavigator().defer();
    }

    public void addSuggestion() {
        galleryViewModel = null;
        getNavigator().addSuggestion();
    }

    public void addNote() {
        getNavigator().addNote();
    }

    public void showDataCaptured() {
        getNavigator().showDataCaptured();
    }

    public ReasonPopUpViewModel getReasonPopUpViewModel() {
        if (reasonPopUpViewModel == null)
            reasonPopUpViewModel = new ReasonPopUpViewModel(getApplication());
        return reasonPopUpViewModel;
    }

    public void setReasonPopUpViewModel(ReasonPopUpViewModel reasonPopUpViewModel) {
        this.reasonPopUpViewModel = reasonPopUpViewModel;
    }

    /**
     * Executed the qr scan detail item either scanned manually or using scanner
     *
     * @param item       QR scan item to be executed
     * @param entityName The name given in case of manual verification
     * @param reason     The reason given in case of manual verification
     */
    public void executeQRScanStepAttribute(QRAttributeScanItem item, String entityName, String reason,
                                           QRCodeScanNavigator qrCodeScanNavigator) {
        String stepAction = item.getEntityName();
        //If scanned using scanner
        if (TextUtils.isEmpty(reason)) {
            stepAction = item.getEntityName().concat("<#>").concat(entityName);
        }

        if (!TextUtils.isEmpty(reason)) {
            stepAction = item.getEntityName().concat("<#>").concat(entityName).concat("<#>").concat(reason);
        }
        String itemUuid = checkListExecuteRepository.executeStepQRScanAttribute(checkListUUID,
                checklistElementDetail.getItemId(),
                checklistElementDetail.getElementId(),
                item.getEntityUuid(),
                attributeItemsList.get(qrScanAttribute.getAttributePosition()).getId(),
                checklistId,
                attributeItemsList.get(qrScanAttribute.getAttributePosition()).getLabel(),
                stepAction,
                item.getUuid());

        //Update get live data query as item uuid is now updated so for getting inserted entries
        //in assigned step attribute we have to update the query
        if (TextUtils.isEmpty(item.getUuid())) {
            attributeItemsList.get(qrScanAttribute.getAttributePosition()).setItemUuid(itemUuid);
        }
        qrCodeScanNavigator.observeQRScanItemsList();
    }

    /**
     * This method gets the detail for items to be scanned for qr scan attribute and
     * saves the returned list in two dimensional arrya
     *
     * @param position Position of the attribute
     */
    public LiveData<List<QRAttributeScanItem>> getQRAttributeDetail(int position) {
        if (qrScanAttribute == null)
            qrScanAttribute = new QRScanAttribute();
        return checkListExecuteRepository.getQRAttributeDetail(attributeItemsList.get(position).getId(),
                attributeItemsList.get(position).getItemUuid(),
                checklistElementDetail.getElementId(),
                checkListUUID);
    }

    public QRScanAttribute getQrScanAttribute() {
        return qrScanAttribute;
    }

}
