/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package manager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 *
 * @author denil
 */
public class pruebasMain {
        public static void main(String[] args) {
        HashMap<Integer, List<Object>> map = new HashMap<>();
        map.put(1, List.of(1, "Dato", "ID", "int", true, 5, 0));
        map.put(2, List.of(2, "Dato", "ID", "int", true, 5, 0));
        map.put(3, List.of(3, "Dato", "NAME", "string", true, 5, 0));
        map.put(4, List.of(4, "Dato", "LASTNAME", "string", true, 5, 0));
        map.put(6, List.of(6, "Dato", "ID", "int", false, 7, 0));

        int keyTable = 5; // Ejemplo de clave de tabla
        int keyDataBase = 0; // Ejemplo de clave de base de datos

        List<List<Object>> listDelete = new ArrayList<>();
        for (Map.Entry<Integer, List<Object>> entry : map.entrySet()) {
            List<Object> list = entry.getValue();
            if ("Dato".equals(list.get(1))
                && (list.get(5) instanceof Integer && (Integer) list.get(5) == keyTable)
                && (list.get(6) instanceof Integer && (Integer) list.get(6) == keyDataBase)) {
                listDelete.add(list);
            }
        }

        List<Object> matchingElements = new ArrayList<>();
        for (int i = 0; i < listDelete.size(); i++) {
            for (int j = i + 1; j < listDelete.size(); j++) {
                List<Object> list1 = listDelete.get(i);
                List<Object> list2 = listDelete.get(j);
                if (list1.get(3).equals(list2.get(3)) && list1.get(5).equals(list2.get(5))) {
                    matchingElements.add(list2.get(0));
                }
            }
        }

        // Mostrar los elementos que cumplen con las condiciones
        for (Object elem : matchingElements) {
            System.out.println(elem);
        }
        }

}
