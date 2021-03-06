/*
 * Copyright 2008 (C) Tom Parker <thpr@users.sourceforge.net>
 * 
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 * 
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 * 
 * You should have received a copy of the GNU Lesser General Public License
 * along with this library; if not, write to the Free Software Foundation, Inc.,
 * 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
 */
package pcgen.cdom.reference;

import pcgen.cdom.base.Loadable;

/**
 * A Qualifier is used to identify a specific instance of a certain type of
 * CDOMObject in order to establish a relationship for that CDOMObject. (This
 * relationship may be automatic qualification, to bypass prerequisites, or may
 * be other relationships in other tokens)
 */
public class Qualifier
{

	/**
	 * The Class of object this Qualifier contains
	 */
	private final Class<? extends Loadable> qualClass;

	/**
	 * A reference to the specific instance of the class of object this
	 * Qualifier contains.
	 */
	private final CDOMSingleRef<? extends Loadable> qualRef;

	/**
	 * Constructs a new Qualifier for the given Class of CDOMObject and the
	 * given reference to the specific instance of CDOMObject this Qualifier
	 * contains.
	 * 
	 * @param objClass
	 *            The given Class of CDOMObject this Qualifier contains
	 * @param ref
	 *            The reference to the specific instance of CDOMObject this
	 *            Qualifier contains.
	 */
	public Qualifier(Class<? extends Loadable> objClass,
			CDOMSingleRef<? extends Loadable> ref)
	{
		if (objClass == null)
		{
			throw new IllegalArgumentException("Class cannot be null");
		}
		if (ref == null)
		{
			throw new IllegalArgumentException("Reference cannot be null");
		}
		qualClass = objClass;
		qualRef = ref;
	}

	/**
	 * Returns the given Class of CDOMObject this Qualifier contains.
	 * 
	 * @return The given Class of CDOMObject this Qualifier contains.
	 */
	public Class<? extends Loadable> getQualifiedClass()
	{
		return qualClass;
	}

	/**
	 * Returns the reference to the specific instance of CDOMObject this
	 * Qualifier contains.
	 * 
	 * @return The reference to the specific instance of CDOMObject this
	 *         Qualifier contains.
	 */
	public CDOMSingleRef<? extends Loadable> getQualifiedReference()
	{
		return qualRef;
	}

	/**
	 * Returns a consistent-with-equals hashCode for this Qualifier
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode()
	{
		return qualClass.hashCode() * 29 + qualRef.hashCode();
	}

	/**
	 * Returns true if the given object is a Qualifier with identical underlying
	 * CDOMObject class and reference.
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj)
	{
		if (obj instanceof Qualifier)
		{
			Qualifier other = (Qualifier) obj;
			return qualClass.equals(other.qualClass)
					&& qualRef.equals(other.qualRef);
		}
		return false;
	}

}
