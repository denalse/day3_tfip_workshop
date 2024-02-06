package sg.edu.nus.iss;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class ShoppingCart {

    private static HashSet<String> itemList = new HashSet<>();
    private String name;

    public ShoppingCart(String _name) {
        this.name = _name;
    }

    public List<String> getItemList() {
        List<String> list = new LinkedList<String>(itemList);
        return list;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void add(String item) {
        if (this.itemList.contains(item)) {
            return;
        }
        this.itemList.add(item);
    }

    public void remove(int index) {
        if (index < itemList.size()) {
            itemList.remove(index);
        }
    }

    public void load(InputStream is) throws IOException {
        String item;
        InputStreamReader reader = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(reader);

        while ((item = br.readLine()) != null) {
            itemList.add(item);
        }
        br.close();
        reader.close();
    }

    public void save(OutputStream os) {
        OutputStreamWriter writer = new OutputStreamWriter(os);
        BufferedWriter bw = new BufferedWriter(writer);

        try {

            for (String item : itemList) {
                try {
                    bw.write(item);
                    bw.newLine();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        } finally {
            try {
                writer.flush();
                bw.flush();
                writer.close();
                bw.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

}
