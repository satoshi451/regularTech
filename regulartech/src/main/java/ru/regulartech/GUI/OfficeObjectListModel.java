package regularTech.GUI;

import regularTech.Pair;

import javax.swing.*;
import java.util.List;

/**
 * Create by Votrin Andrey (votrin.andrey@caesber.ru).
 * DATE: 05.05.2014
 * TIME: 15:45
 */
public class OfficeObjectListModel extends DefaultListModel {
    private  List<Pair<Integer, String>> data;

    public OfficeObjectListModel(List<Pair<Integer, String>> data) {
        super();
        this.data = data;
    }
}
