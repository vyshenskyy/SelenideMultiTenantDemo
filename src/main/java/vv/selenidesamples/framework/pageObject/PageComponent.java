package vv.selenidesamples.framework.pageObject;


import com.codeborne.selenide.ElementsCollection;
import static com.codeborne.selenide.Selenide.*;

import com.codeborne.selenide.SelenideElement;

public abstract class PageComponent  {
	private final String elementCssLocator;
	private final SelenideElement ancestorElement;
	private final String ancestorElementCssLocator;
	
	/**
	 * @param ancestorElementCssLocator
	 * @param elementCssLocator
	 */
	public PageComponent(String ancestorElementCssLocator,  String elementCssLocator) {
		this.ancestorElementCssLocator = ancestorElementCssLocator;
		this.ancestorElement =  null == ancestorElementCssLocator ? null  : $(ancestorElementCssLocator);
		this.elementCssLocator = elementCssLocator;
	}
	
	
	/**
	 * @param parentElementCssLocator
	 * @param parentElement
	 * @param elementCssLocator
	 */
	protected PageComponent(String parentElementCssLocator,  SelenideElement parentElement, String elementCssLocator) {
		this.ancestorElementCssLocator = parentElementCssLocator;
		this.ancestorElement = parentElement;
		this.elementCssLocator = elementCssLocator;
	}
	
	/**
	 * SelenideElement that represents PageComponent 
	 * @return SelenideElement
	 */
	public SelenideElement getPageComponentElement() {
		if(null == elementCssLocator ) {
			return null;
		}  else {
			return (null==ancestorElement )? $(elementCssLocator) : ancestorElement.$(elementCssLocator);
		}		
	}
	
	public String getElementCssLocator() {
		return elementCssLocator;
	}
	public SelenideElement getAncestorElement() {
		return ancestorElement;
	}
	
	public String getAncestorElementCssLocator() {
		return ancestorElementCssLocator;
	}
	
	/**
	 * Finds SelenideElement with given cssElementLocator that is relative to the element that represents PageComponent
	 * @param cssElementLocator
	 * @return SelenideElement
	 */
	public SelenideElement findDescenadant(String cssElementLocator) {
		SelenideElement componentElement = getPageComponentElement();
		return (null == componentElement) ? $(cssElementLocator) : componentElement.$(cssElementLocator);
	}
	
	
	public ElementsCollection findDescendants(String cssElementLocator) {
		SelenideElement componentElement = getPageComponentElement();
		return (null == componentElement) ? $$(cssElementLocator) : componentElement.$$(cssElementLocator);		
	}
	
}
