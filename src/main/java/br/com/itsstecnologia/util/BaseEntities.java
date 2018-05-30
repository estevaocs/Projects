package br.com.itsstecnologia.util;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.data.jpa.domain.AbstractPersistable;

import java.io.Serializable;



public abstract class BaseEntities<PK extends Serializable> extends AbstractPersistable<PK> implements Serializable {

    private  static final long serialVersionUID = 201805300223L;

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }

    @Override
    public boolean equals(Object object){
        return EqualsBuilder.reflectionEquals(this, object);
    }

}
