package org.citygml4j.binding.cityjson.geometry;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.citygml4j.binding.cityjson.appearance.MaterialAdapter;
import org.citygml4j.binding.cityjson.appearance.SolidCollectionMaterialObject;
import org.citygml4j.binding.cityjson.appearance.SolidCollectionTextureObject;
import org.citygml4j.binding.cityjson.appearance.TextureAdapter;

import com.google.gson.annotations.JsonAdapter;

public abstract class AbstractSolidCollectionType extends AbstractSolidType
implements GeometryWithAppearance<SolidCollectionMaterialObject, SolidCollectionTextureObject> {
	private final GeometryTypeName type;
	private List<List<List<List<List<Integer>>>>> boundaries = new ArrayList<>();	
	private SolidCollectionSemanticsObject semantics;
	@JsonAdapter(MaterialAdapter.class)
	private Map<String, SolidCollectionMaterialObject> material;
	@JsonAdapter(TextureAdapter.class)
	private Map<String, SolidCollectionTextureObject> texture;
	
	public AbstractSolidCollectionType(GeometryTypeName type) {
		this.type = type;
	}
	
	@Override
	public GeometryTypeName getType() {
		return type;
	}
	
	public void addSolid(List<List<List<List<Integer>>>> solid) {
		if (solid != null && solid.size() > 0)
			boundaries.add(solid);
	}

	public List<List<List<List<List<Integer>>>>> getSolids() {
		return boundaries;
	}

	public void setSolids(List<List<List<List<List<Integer>>>>> solids) {
		if (solids != null)
			boundaries = solids;
	}
	
	public void unsetSolids() {
		boundaries.clear();
	}
	
	@Override
	public boolean isSetSemantics() {
		return semantics != null;
	}

	@Override
	public SolidCollectionSemanticsObject getSemantics() {
		return semantics;
	}

	public void setSemantics(SolidCollectionSemanticsObject semantics) {
		this.semantics = semantics;
	}
	
	public void unsetSemantics() {
		semantics = null;
	}
	
	@Override
	public boolean isSetMaterial() {
		return material != null;
	}
	
	public void addMaterial(SolidCollectionMaterialObject materialObject) {
		if (material == null)
			material = new HashMap<>();
		
		material.put(materialObject.getTheme(), materialObject);
	}
	
	@Override
	public Collection<SolidCollectionMaterialObject> getMaterial() {
		return material.values();
	}
	
	public SolidCollectionMaterialObject getMaterial(String theme) {
		return material != null ? material.get(theme) : null;
	}

	public void setMaterial(List<SolidCollectionMaterialObject> material) {
		if (material == null)
			this.material = null;
		else {
			for (SolidCollectionMaterialObject object : material)
				this.material.put(object.getTheme(), object);
		}
	}
	
	public void removeMaterial(SolidCollectionMaterialObject materialObject) {
		if (this.material != null)
			this.material.remove(materialObject.getTheme());
	}
	
	public void removeMaterial(String theme) {
		if (this.material != null)
			this.material.remove(theme);
	}
	
	public void unsetMaterial() {
		material = null;
	}
	
	@Override
	public boolean isSetTexture() {
		return texture != null;
	}
	
	public void addTexture(SolidCollectionTextureObject textureObject) {
		if (texture == null)
			texture = new HashMap<>();
		
		texture.put(textureObject.getTheme(), textureObject);
	}
	
	@Override
	public Collection<SolidCollectionTextureObject> getTexture() {
		return texture.values();
	}
	
	public SolidCollectionTextureObject getTexture(String theme) {
		return texture != null ? texture.get(theme) : null;
	}

	public void setTexture(List<SolidCollectionTextureObject> texture) {
		if (texture == null)
			this.texture = null;
		else {
			for (SolidCollectionTextureObject object : texture)
				this.texture.put(object.getTheme(), object);
		}
	}
	
	public void removeTexture(SolidCollectionTextureObject textureObject) {
		if (texture != null)
			texture.remove(textureObject.getTheme());
	}
	
	public void removeTexture(String theme) {
		if (texture != null)
			texture.remove(theme);
	}
	
	public void unsetTexture() {
		texture = null;
	}

}
