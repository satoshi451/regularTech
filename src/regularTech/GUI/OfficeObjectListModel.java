package regularTech.GUI;

import javax.swing.*;
import java.util.List;

/**
 * Create by Votrin Andrey (votrin.andrey@caesber.ru).
 * DATE: 05.05.2014
 * TIME: 15:45
 */
public class OfficeObjectListModel extends DefaultListModel {
    private List<String> data;

    public OfficeObjectListModel(List<String> data) {
        super();
        this.data = data;
    }

    @Override
    public int getSize() {
        return data.size();
    }

}
