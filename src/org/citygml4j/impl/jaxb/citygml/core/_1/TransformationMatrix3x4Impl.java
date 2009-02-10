package org.citygml4j.impl.jaxb.citygml.core._1;

import java.util.List;

import org.citygml4j.geometry.Matrix;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.citygml.CityGMLModule;
import org.citygml4j.model.citygml.core.CoreModule;
import org.citygml4j.model.citygml.core.TransformationMatrix3x4;

public class TransformationMatrix3x4Impl implements TransformationMatrix3x4 {
	private Matrix matrix;

	public TransformationMatrix3x4Impl() {
		matrix = new Matrix(3, 4);
	}

	public TransformationMatrix3x4Impl(Matrix matrix) {
		if (matrix.getRowDimension() != 3 || matrix.getColumnDimension() != 4)
			throw new IllegalArgumentException("Matrix dimensions must be 3x4.");
		
		this.matrix = matrix;
	}
	
	public TransformationMatrix3x4Impl(List<Double> vals) {
		if (vals.size() != 12)
			throw new IllegalArgumentException("List size must be 12.");

		matrix = new Matrix(3, 4);
		matrix.setMatrix(vals);
	}

	@Override
	public Matrix getMatrix() {
		return matrix;
	}

	@Override
	public void setMatrix(Matrix matrix) {
		if (matrix.getRowDimension() != 3 || matrix.getColumnDimension() != 4)
			throw new IllegalArgumentException("Matrix dimensions must be 3x4.");

		this.matrix = matrix;
	}

	@Override
	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.TRANSFORMATIONMATRIX3X4;
	}

	@Override
	public final CityGMLModule getCityGMLModule() {
		return CoreModule.v1_0_0;
	}
}
