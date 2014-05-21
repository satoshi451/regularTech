package regularTech.officeObjects;

import regularTech.graphical.GraphObject;

import java.math.BigDecimal;

/**
 * Create by Votrin Andrey (votrin.andrey@caesber.ru).
 * DATE: 18.04.2014
 * TIME: 21:41
 */
public abstract class OfficeObject extends GraphObject implements baseActions {
    protected String name;
    protected String description;
    protected BigDecimal IndentureNumber;
    protected Integer status;

    protected static final Integer ALL_IS_OK = 1;
    protected static final Integer BREAK = 2;
    protected static final Integer ON_DIAGNOSTIC = 3;
    protected static final Integer BREAKED = 4;

    public OfficeObject() {
        this.description = "no_description";
        this.name = "no_name";
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getIndentureNumber() {
        return IndentureNumber;
    }
    public void setIndentureNumber(BigDecimal indentureNumber) {
        IndentureNumber = indentureNumber;
    }

    @Override
    public void changeRoom(){

    }
    @Override
    public  void changeStatus(Integer status){
        this.status = status;
    }

}
