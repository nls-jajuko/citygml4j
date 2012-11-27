/*
 * This file is part of citygml4j.
 * Copyright (c) 2007 - 2010
 * Institute for Geodesy and Geoinformation Science
 * Technische Universitaet Berlin, Germany
 * http://www.igg.tu-berlin.de/
 *
 * The citygml4j library is free software:
 * you can redistribute it and/or modify it under the terms of the
 * GNU Lesser General Public License as published by the Free
 * Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library. If not, see 
 * <http://www.gnu.org/licenses/>.
 */
package org.citygml4j.impl.citygml.transportation;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.impl.gml.feature.FeaturePropertyImpl;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.citygml.transportation.TrafficArea;
import org.citygml4j.model.citygml.transportation.TrafficAreaProperty;
import org.citygml4j.model.common.base.ModelType;
import org.citygml4j.model.module.citygml.TransportationModule;

public class TrafficAreaPropertyImpl extends FeaturePropertyImpl<TrafficArea> implements TrafficAreaProperty {
	private TransportationModule module;
	
	public TrafficAreaPropertyImpl() {

	}

	public TrafficAreaPropertyImpl(TransportationModule module) {
		this.module = module;
	}
	
	public TrafficArea getTrafficArea() {
		return super.getObject();
	}

	public boolean isSetTrafficArea() {
		return super.isSetObject();
	}

	public void setTrafficArea(TrafficArea trafficArea) {
		super.setObject(trafficArea);
	}

	public void unsetTrafficArea() {
		super.unsetObject();
	}

	@Override
	public ModelType getModelType() {
		return ModelType.CITYGML;
	}

	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.TRAFFIC_AREA_PROPERTY;
	}

	public final TransportationModule getCityGMLModule() {
		return module;
	}

	public boolean isSetCityGMLModule() {
		return module != null;
	}

	@Override
	public Class<TrafficArea> getAssociableClass() {
		return TrafficArea.class;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new TrafficAreaPropertyImpl(), copyBuilder);
	}

	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		TrafficAreaProperty copy = (target == null) ? new TrafficAreaPropertyImpl() : (TrafficAreaProperty)target;
		return super.copyTo(copy, copyBuilder);
	}

}