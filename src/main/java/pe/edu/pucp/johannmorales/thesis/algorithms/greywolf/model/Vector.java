package pe.edu.pucp.johannmorales.thesis.algorithms.greywolf.model;

import java.math.BigDecimal;

public class Vector {

    private Integer dimension;
    private Boolean isConstant;
    private BigDecimal constantValue;
    private BigDecimal[] components;

    public static Vector createConstant(Integer dimensions, BigDecimal value) {
        Vector vector = new Vector();
        vector.dimension = dimensions;
        vector.isConstant = true;
        vector.constantValue = value;
        return vector;
    }

    public static Vector create(Integer dimensions) {
        Vector vector = new Vector();
        vector.dimension = dimensions;
        vector.isConstant = false;
        vector.constantValue = null;
        vector.components = new BigDecimal[dimensions];
        return vector;
    }

    public void set(Integer dimension, BigDecimal value) {
        if(this.isConstant) {
            throw new UnsupportedOperationException("Can't change components of a constant vector");
        }
        this.components[dimension] = value;
    }

    public BigDecimal get(Integer dimension) {
        if(this.isConstant) {
            return this.constantValue;
        } else {
            return this.components[dimension];
        }
    }

    public Vector dotProduct(Vector other) {
        if(this.isConstant && other.isConstant) {
            return Vector.createConstant(dimension, this.constantValue.multiply(other.constantValue));
        } else {
            Vector result = Vector.create(dimension);
            for (Integer i = 0; i < dimension; i++) {
                result.set(i, this.get(i).multiply(other.get(i)));
            }
            return result;
        }
    }

    public Vector abs() {
        if(this.isConstant) {
            return Vector.createConstant(dimension, this.constantValue.abs());
        } else {
            Vector result = Vector.create(dimension);
            for (Integer i = 0; i < dimension; i++) {
                result.set(i, this.get(i).abs());
            }
            return result;
        }
    }

}