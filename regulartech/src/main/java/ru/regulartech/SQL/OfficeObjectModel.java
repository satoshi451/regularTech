package regularTech.SQL;

/**
 * Create by Votrin Andrey (votrin.andrey@caesber.ru).
 * DATE: 30.04.2014
 * TIME: 16:35
 */
public class OfficeObjectModel {
    public static final int OFFICE_OBJECT_PC        = 1;
    public static final int OFFICE_OBJECT_FURNITURE = 2;
    public static final int OFFICE_OBJECT_COMMON    = 3;
    public static final int OFFICE_OBJECT_ROUTER    = 4;
    public static final int OFFICE_OBJECT_PRINTER   = 5;
    public static final int OFFICE_OBJECT_MONITOR   = 6;
    public static final int OFFICE_OBJECT_LAPTOP    = 7;

    private Integer id;
    private String name;
    private Integer officeObjectTypeId;

    public OfficeObjectModel(Integer id, String name, Integer officeObjectTypeId) {
        this.id = id;
        this.name = name;
        this.officeObjectTypeId = officeObjectTypeId;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getOfficeObjectTypeId() {
        return officeObjectTypeId;
    }
}
