package com.kwanhon.model;

import com.kwanhon.common.db.BaseModel;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Administrator on 2017/5/17 0017.
 */
@Table(name="t_type")
public class NewsType extends BaseModel {
    @Id
    @Column(name="type_id")
    private Integer typeId;

    @Column(name="type_name")
    private String typeName;

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        set(getMetaData(this.getClass()).getColumnMapping().get("typeId"), typeId);
        this.typeId = typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        set(getMetaData(this.getClass()).getColumnMapping().get("typeName"), typeName);
        this.typeName = typeName;
    }
}
