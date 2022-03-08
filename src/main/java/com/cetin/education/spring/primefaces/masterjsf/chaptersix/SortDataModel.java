package com.cetin.education.spring.primefaces.masterjsf.chaptersix;

import javax.faces.model.CollectionDataModel;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Map;

/**
 * @Author mehmetali.cetin
 * @Date 2022-01-26
 */

//Now, our custom CollectionDataModel class with sorting capabilities is ready.
public class SortDataModel<T> extends CollectionDataModel<T> {

    CollectionDataModel<T> collectionDataModel;
    private Integer rows[];

    public SortDataModel(CollectionDataModel<T> collectionDataModel) {
        this.collectionDataModel = collectionDataModel;
        initRows();
    }

    private void initRows() {
        int rowCount = collectionDataModel.getRowCount();
        if (rowCount != -1) {
            this.rows = new Integer[rowCount];
            for (int i = 0; i < rowCount; ++i) {
                rows[i] = i;
            }
        }
    }

    @Override
    public void setRowIndex(int rowIndex) {
        if ((0 <= rowIndex) && (rowIndex < rows.length)) {
            collectionDataModel.setRowIndex(rows[rowIndex]);
        } else {
            collectionDataModel.setRowIndex(rowIndex);
        }
    }

    public void sortThis(final Comparator<T> comparator) {
        Comparator<Integer> rowc = new Comparator<Integer>() {
            @Override
            public int compare(Integer key_1, Integer key_2) {
                T key_1_data = getData(key_1);
                T key_2_data = getData(key_2);
                return comparator.compare(key_1_data, key_2_data);
            }
        };
        Arrays.sort(rows, rowc);
    }

    private T getData(Integer row) {
        int baseRowIndex = collectionDataModel.getRowIndex();
        collectionDataModel.setRowIndex(row);
        T newRowData = collectionDataModel.getRowData();
        collectionDataModel.setRowIndex(baseRowIndex);
        return newRowData;
    }
}
