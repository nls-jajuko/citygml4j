package org.citygml4j.builder.json.objects;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.citygml4j.builder.json.objects.appearance.AppearanceType;
import org.citygml4j.builder.json.objects.feature.AbstractCityObjectType;
import org.citygml4j.builder.json.objects.feature.MetadataType;
import org.citygml4j.builder.json.objects.geometry.TransformType;

import com.google.gson.annotations.SerializedName;

public class CityJSON {
	private final String type = "CityModel";
	private final String version = "0.3";
	private MetadataType metadata;
	@SerializedName("CityObjects")
	private Map<String, AbstractCityObjectType> cityObjects = new HashMap<>();
	private List<List<Double>> vertices = new ArrayList<>();
	private TransformType transform;
	private AppearanceType appearance;
	
	public String getType() {
		return type;
	}

	public boolean isSetVersion() {
		return version != null;
	}

	public String getVersion() {
		return version;
	}

	public boolean isSetMetadata() {
		return metadata != null;
	}
	
	public MetadataType getMetadata() {
		return metadata;
	}

	public void setMetadata(MetadataType metadata) {
		this.metadata = metadata;
	}
	
	public void addCityObject(AbstractCityObjectType cityObject) {
		cityObjects.put(cityObject.getGmlId(), cityObject);
	}

	public Collection<AbstractCityObjectType> getCityObjects() {
		return cityObjects.values();
	}

	public void setCityObjects(List<AbstractCityObjectType> cityObjects) {
		if (cityObjects != null) {
			for (AbstractCityObjectType cityObject : cityObjects)
				this.cityObjects.put(cityObject.getGmlId(), cityObject);
		}
	}
	
	public void addVertex(List<Double> vertex) {
		if (vertex != null && vertex.size() == 3)
			vertices.add(vertex);
	}

	public List<List<Double>> getVertices() {
		return vertices;
	}

	public void setVertices(List<List<Double>> vertices) {
		if (vertices != null)
			this.vertices = vertices;
	}

	public boolean isSetTransform() {
		return transform != null;
	}
	
	public TransformType getTransform() {
		return transform;
	}

	public void setTransform(TransformType transform) {
		this.transform = transform;
	}

	public boolean isSetAppearance() {
		return appearance != null;
	}
	
	public AppearanceType getAppearance() {
		return appearance;
	}

	public void setAppearance(AppearanceType appearance) {
		this.appearance = appearance;
	}
	
}