package com.icarus.util;

import android.util.SparseArray;

import com.icarus.models.QRAttributeScanItem;

import java.util.List;

/**
 * Created by Monika Rana on 12/05/2020
 */
public class QRScanAttribute {

    private int attributePosition = 0;
    private int qrScanDetailItemPosition = 0;
    //Saving qr scan attribute detail items with attribute index as key and its detail items as values
    private SparseArray<List<QRAttributeScanItem>> scanQRAttributesSparseArray;

    public QRAttributeScanItem getNextQRScanAttributeIfAny() {
        if (scanQRAttributesSparseArray == null)
            return null;
        for (int i = attributePosition; i < scanQRAttributesSparseArray.size(); i++) {
            List<QRAttributeScanItem> qrAttributes = scanQRAttributesSparseArray.get(i);

            if (qrAttributes == null) {
                continue;
            }

            for (int j = qrScanDetailItemPosition + 1; j < qrAttributes.size(); j++) {
                QRAttributeScanItem item = qrAttributes.get(j);
                if (item.getUuid() == null) {
                    qrScanDetailItemPosition = j;
                    attributePosition = i;
                    return item;
                }
            }
        }
        return null;
    }

    public boolean checkIfQRScanPending() {
        if (scanQRAttributesSparseArray == null)
            return false;

        for (int i = 0; i < scanQRAttributesSparseArray.size(); i++) {
            List<QRAttributeScanItem> qrAttributes = scanQRAttributesSparseArray.get(i);

            if (qrAttributes == null) {
                continue;
            }

            for (int j = 0; j < qrAttributes.size(); j++) {
                if (qrAttributes.get(j).getUuid() == null) {
                    qrScanDetailItemPosition = j;
                    attributePosition = i;
                    return true;
                }
            }
        }

        return false;
    }

    public int getAttributePosition() {
        return attributePosition;
    }

    public SparseArray<List<QRAttributeScanItem>> getScanQRAttributesSparseArray() {
        if (scanQRAttributesSparseArray == null)
            scanQRAttributesSparseArray = new SparseArray<>();
        return scanQRAttributesSparseArray;
    }

    public QRAttributeScanItem getItemToBeScanned() {
        return scanQRAttributesSparseArray.get(attributePosition).get(qrScanDetailItemPosition);
    }

    public void setAttributePosition(int attributePosition) {
        this.attributePosition = attributePosition;
    }

    public void setQrScanDetailItemPosition(int qrScanDetailItemPosition) {
        this.qrScanDetailItemPosition = qrScanDetailItemPosition;
    }

    public boolean checkIfQRScanPendingForAttribute(int attributePosition) {
        if (scanQRAttributesSparseArray == null) {
            return false;
        }

        List<QRAttributeScanItem> qrAttributes = scanQRAttributesSparseArray.get(attributePosition);

        if (qrAttributes == null) {
            return false;
        }

        for (QRAttributeScanItem qrAttributeScanItem : qrAttributes) {
            if (qrAttributeScanItem == null) {
                return true;
            }
        }

        return false;
    }
}
