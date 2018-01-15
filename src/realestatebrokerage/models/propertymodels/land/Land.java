package realestatebrokerage.models.propertymodels.land;

import java.io.Serializable;

public class Land implements Serializable{
    private TypeOfLand type;
    private float size;

    public Land(TypeOfLand type, float size) {
        this.type = type;
        this.size = size;
    }

    public float getSize() {
        return size;
    }

    public void setSize(float size) {
        this.size = size;
    }

    public TypeOfLand getType() {
        return type;
    }

    public void setType(TypeOfLand type) {
        this.type = type;
    }
}
