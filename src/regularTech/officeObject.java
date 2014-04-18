package regularTech;

import java.math.BigDecimal;

/**
 * Create by Votrin Andrey (votrin.andrey@caesber.ru).
 * DATE: 18.04.2014
 * TIME: 21:41
 */
public abstract class officeObject extends graphObject implements baseActions {
    protected String name;
    protected String description;
    protected BigDecimal IndentureNumber;

    public officeObject() {
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
}
