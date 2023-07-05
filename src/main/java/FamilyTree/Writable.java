package FamilyTree;

import java.io.Serializable;

public interface Writable {
    boolean saveInfo(Serializable serializable,String filePath);
    Object readInfo(String filePath);
}
