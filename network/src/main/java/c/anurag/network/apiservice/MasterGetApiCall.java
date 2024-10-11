package c.anurag.network.apiservice;

import android.content.Context;

import c.anurag.network.ApiService;
import c.anurag.network.RetrofitApiServiceFactory;
import c.anurag.network.beans.associated.checklist.AssociatedChecklistsEntry;
import c.anurag.network.beans.associated.checklist.AssociatedChecklistsResponse;
import c.anurag.network.beans.cautionhazards.CautionHazardsEntry;
import c.anurag.network.beans.cautionhazards.CautionHazardsResponse;
import c.anurag.network.beans.checklist.ChecklistsEntry;
import c.anurag.network.beans.checklist.ChecklistsResponse;
import c.anurag.network.beans.checklist.elements.ChecklistElementsEntry;
import c.anurag.network.beans.checklist.elements.ChecklistElementsResponse;
import c.anurag.network.beans.checklist.locations.ChecklistLocationsEntry;
import c.anurag.network.beans.checklist.locations.ChecklistLocationsResponse;
import c.anurag.network.beans.checklist.logos.ChecklistLogosEntry;
import c.anurag.network.beans.checklist.logos.ChecklistLogosResponse;
import c.anurag.network.beans.checklist.ppes.ChecklistPpesEntry;
import c.anurag.network.beans.checklist.ppes.ChecklistPpesResponse;
import c.anurag.network.beans.checklist.room.equipments.ChecklistRoomEquipmentsEntry;
import c.anurag.network.beans.checklist.room.equipments.ChecklistRoomEquipmentsResponse;
import c.anurag.network.beans.checklist.texts.ChecklistTextsEntry;
import c.anurag.network.beans.checklist.texts.ChecklistTextsResponse;
import c.anurag.network.beans.checklist.titles.ChecklistTitlesEntry;
import c.anurag.network.beans.checklist.titles.ChecklistTitlesResponse;
import c.anurag.network.beans.checklist.types.ChecklistTypesEntry;
import c.anurag.network.beans.checklist.types.ChecklistTypesResponse;
import c.anurag.network.beans.client.logo.ClientLogoResponse;
import c.anurag.network.beans.client.logo.ClientLogosEntry;
import c.anurag.network.beans.client.settings.ClientSettingsEntry;
import c.anurag.network.beans.client.settings.ClientSettingsResponse;
import c.anurag.network.beans.decisions.DecisionsEntry;
import c.anurag.network.beans.decisions.DecisionsResponse;
import c.anurag.network.beans.departments.DepartmentsEntry;
import c.anurag.network.beans.departments.DepartmentsResponse;
import c.anurag.network.beans.groups.GroupsEntry;
import c.anurag.network.beans.groups.GroupsResponse;
import c.anurag.network.beans.hazards.HazardsEntry;
import c.anurag.network.beans.hazards.HazardsResponse;
import c.anurag.network.beans.itemtypes.ItemTypesEntry;
import c.anurag.network.beans.itemtypes.ItemTypesResponse;
import c.anurag.network.beans.location.LocationsEntry;
import c.anurag.network.beans.location.LocationsResponse;
import c.anurag.network.beans.location.departments.LocationDepartmentsEntry;
import c.anurag.network.beans.location.departments.LocationDepartmentsResponse;
import c.anurag.network.beans.location.equipments.LocationEquipmentsEntry;
import c.anurag.network.beans.location.equipments.LocationEquipmentsResponse;
import c.anurag.network.beans.location.room.equipments.LocationRoomEquipmentsEntry;
import c.anurag.network.beans.location.room.equipments.LocationRoomEquipmentsResponse;
import c.anurag.network.beans.ncw.NCWEntry;
import c.anurag.network.beans.ncw.NCWResponse;
import c.anurag.network.beans.notehazards.NoteHazardsEntry;
import c.anurag.network.beans.notehazards.NoteHazardsResponse;
import c.anurag.network.beans.ppes.PpesEntry;
import c.anurag.network.beans.ppes.PpesResponse;
import c.anurag.network.beans.resource.ResourcesEntry;
import c.anurag.network.beans.resource.ResourcesResponse;
import c.anurag.network.beans.resource.links.ResourceLinksEntry;
import c.anurag.network.beans.resource.links.ResourceLinksResponse;
import c.anurag.network.beans.rooms.RoomsEntry;
import c.anurag.network.beans.rooms.RoomsResponse;
import c.anurag.network.beans.step.StepsEntry;
import c.anurag.network.beans.step.StepsResponse;
import c.anurag.network.beans.step.attributes.StepAttributesEntry;
import c.anurag.network.beans.step.attributes.StepAttributesResponse;
import c.anurag.network.beans.step.result.functions.StepResultFunctionsEntry;
import c.anurag.network.beans.step.result.functions.StepResultFunctionsResponse;
import c.anurag.network.beans.user.UsersEntry;
import c.anurag.network.beans.user.UsersResponse;
import c.anurag.network.beans.user.favorites.UserFavoritesEntry;
import c.anurag.network.beans.user.favorites.UserFavoritesResponse;
import c.anurag.network.beans.user.locationdepartments.UserLocationDepartmentsEntry;
import c.anurag.network.beans.user.locationdepartments.UserLocationDepartmentsResponse;
import c.anurag.network.beans.warninghazards.WarningHazardsEntry;
import c.anurag.network.beans.warninghazards.WarningHazardsResponse;

/**
 * Created by anuragpurwar
 */

public class MasterGetApiCall extends AssignedGetApiCall {
    public MasterGetApiCall(Context context, RetrofitApiServiceFactory factory, ApiCallback apiCallback) {
        super(context, factory, apiCallback);
    }

    @Override
    public ApiService getService() {
        return service;
    }

    @Override
    public void getAssociatedChecklists(final String apiName, final String tableName) {
        getGenericWithEntry(apiName, AssociatedChecklistsResponse.class, new AssociatedChecklistsEntry(tableName, icarusDatabaseManager));
    }

    @Override
    public void getResources(final String apiName, final String tableName) {
        getGenericWithEntry(apiName, ResourcesResponse.class, new ResourcesEntry(tableName, icarusDatabaseManager));
    }

    @Override
    public void getUserFavorites(final String apiName, final String tableName) {
        getGenericWithEntry(apiName, UserFavoritesResponse.class, new UserFavoritesEntry(tableName, icarusDatabaseManager));
    }

    @Override
    public void getChecklistLocations(final String apiName, final String tableName) {
        getGenericWithEntry(apiName, ChecklistLocationsResponse.class, new ChecklistLocationsEntry(tableName, icarusDatabaseManager));
    }

    @Override
    public void getClientSettings(final String apiName, final String tableName) {
        getGenericWithEntry(apiName, ClientSettingsResponse.class, new ClientSettingsEntry(tableName, icarusDatabaseManager));
    }

    @Override
    public void getUsers(final String apiName, final String tableName) {
        getGenericWithEntry(apiName, UsersResponse.class, new UsersEntry(context, tableName, icarusDatabaseManager));
    }


    @Override
    public void getClientLogos(final String apiName, final String tableName) {
        getGenericWithEntry(apiName, ClientLogoResponse.class, new ClientLogosEntry(context, tableName, icarusDatabaseManager));
    }

    @Override
    public void getDepartments(final String apiName, final String tableName) {
        getGenericWithEntry(apiName, DepartmentsResponse.class, new DepartmentsEntry(tableName, icarusDatabaseManager));
    }

    @Override
    public void getChecklistTypes(final String apiName, final String tableName) {
        getGenericWithEntry(apiName, ChecklistTypesResponse.class, new ChecklistTypesEntry(tableName, icarusDatabaseManager));
    }

    @Override
    public void getHazards(final String apiName, final String tableName) {
        getGenericWithEntry(apiName, HazardsResponse.class, new HazardsEntry(context, tableName, icarusDatabaseManager));
    }

    @Override
    public void getPpes(final String apiName, final String tableName) {
        getGenericWithEntry(apiName, PpesResponse.class, new PpesEntry(context, tableName, icarusDatabaseManager));
    }

    @Override
    public void getGroups(final String apiName, final String tableName) {
        getGenericWithEntry(apiName, GroupsResponse.class, new GroupsEntry(tableName, icarusDatabaseManager));
    }

    @Override
    public void getItemTypes(final String apiName, final String tableName) {
        getGenericWithEntry(apiName, ItemTypesResponse.class, new ItemTypesEntry(tableName, icarusDatabaseManager));
    }

    @Override
    public void getLocations(final String apiName, final String tableName) {
        getGenericWithEntry(apiName, LocationsResponse.class, new LocationsEntry(tableName, icarusDatabaseManager));
    }

    @Override
    public void getRooms(final String apiName, final String tableName) {
        getGenericWithEntry(apiName, RoomsResponse.class, new RoomsEntry(tableName, icarusDatabaseManager));
    }

    @Override
    public void getEquipments(final String apiName, final String tableName) {
        getRooms(apiName, tableName);
    }

    @Override
    public void getLocationDepartments(final String apiName, final String tableName) {
        getGenericWithEntry(apiName, LocationDepartmentsResponse.class, new LocationDepartmentsEntry(tableName, icarusDatabaseManager));
    }

    @Override
    public void getLocationEquipments(String apiName, final String tableName) {
        getGenericWithEntry(apiName, LocationEquipmentsResponse.class, new LocationEquipmentsEntry(tableName, icarusDatabaseManager));
    }

    @Override
    public void getLocationRoomEquipments(final String apiName, final String tableName) {
        getGenericWithEntry(apiName, LocationRoomEquipmentsResponse.class, new LocationRoomEquipmentsEntry(tableName, icarusDatabaseManager));
    }

    @Override
    public void getUserLocationDepartments(final String apiName, final String tableName) {
        getGenericWithEntry(apiName, UserLocationDepartmentsResponse.class, new UserLocationDepartmentsEntry(tableName, icarusDatabaseManager));
    }

    @Override
    public void getChecklists(final String apiName, final String tableName) {
        getGenericWithEntry(apiName, ChecklistsResponse.class, new ChecklistsEntry(tableName, icarusDatabaseManager));
    }

    @Override
    public void getChecklistTitles(final String apiName, final String tableName) {
        getGenericWithEntry(apiName, ChecklistTitlesResponse.class, new ChecklistTitlesEntry(tableName, icarusDatabaseManager));
    }

    @Override
    public void getChecklistLogos(final String apiName, final String tableName) {
        getGenericWithEntry(apiName, ChecklistLogosResponse.class, new ChecklistLogosEntry(context, tableName, icarusDatabaseManager));
    }

    @Override
    public void getChecklistTexts(final String apiName, final String tableName) {
        getGenericWithEntry(apiName, ChecklistTextsResponse.class, new ChecklistTextsEntry(tableName, icarusDatabaseManager));
    }

    @Override
    public void getSteps(final String apiName, final String tableName) {
        getGenericWithEntry(apiName, StepsResponse.class, new StepsEntry(tableName, icarusDatabaseManager));
    }

    @Override
    public void getDecisions(final String apiName, final String tableName) {
        getGenericWithEntry(apiName, DecisionsResponse.class, new DecisionsEntry(tableName, icarusDatabaseManager));
    }

    @Override
    public void getCautions(final String apiName, final String tableName) {
        getNCW(apiName, tableName);
    }

    @Override
    public void getNotes(final String apiName, final String tableName) {
        getNCW(apiName, tableName);
    }

    @Override
    public void getWarnings(final String apiName, final String tableName) {
        getNCW(apiName, tableName);
    }

    private void getNCW(final String apiName, final String tableName) {
        getGenericWithEntry(apiName, NCWResponse.class, new NCWEntry(tableName, icarusDatabaseManager));
    }

    @Override
    public void getCautionHazards(final String apiName, final String tableName) {
        getGenericWithEntry(apiName, CautionHazardsResponse.class, new CautionHazardsEntry(tableName, icarusDatabaseManager));
    }

    @Override
    public void getWarningHazards(final String apiName, final String tableName) {
        getGenericWithEntry(apiName, WarningHazardsResponse.class, new WarningHazardsEntry(tableName, icarusDatabaseManager));
    }

    @Override
    public void getNoteHazards(final String apiName, final String tableName) {
        getGenericWithEntry(apiName, NoteHazardsResponse.class, new NoteHazardsEntry(tableName, icarusDatabaseManager));
    }

    @Override
    public void getStepAttributes(final String apiName, final String tableName) {
        getGenericWithEntry(apiName, StepAttributesResponse.class, new StepAttributesEntry(tableName, icarusDatabaseManager));
    }

    @Override
    public void getChecklistPpes(final String apiName, final String tableName) {
        getGenericWithEntry(apiName, ChecklistPpesResponse.class, new ChecklistPpesEntry(tableName, icarusDatabaseManager));
    }

    @Override
    public void getStepResultFunctions(final String apiName, final String tableName) {
        getGenericWithEntry(apiName, StepResultFunctionsResponse.class, new StepResultFunctionsEntry(tableName, icarusDatabaseManager));
    }

    @Override
    public void getResourceLinks(final String apiName, final String tableName) {
        getGenericWithEntry(apiName, ResourceLinksResponse.class, new ResourceLinksEntry(tableName, icarusDatabaseManager));
    }

    @Override
    public void getChecklistElements(final String apiName, final String tableName) {
        getGenericWithEntry(apiName, ChecklistElementsResponse.class, new ChecklistElementsEntry(tableName, icarusDatabaseManager));
    }

    @Override
    public void getChecklistRoomEquipments(final String apiName, final String tableName) {
        getGenericWithEntry(apiName, ChecklistRoomEquipmentsResponse.class, new ChecklistRoomEquipmentsEntry(tableName, icarusDatabaseManager));
    }
}
