package pageObjects;

import java.io.IOException;
import java.util.List;

import org.apache.commons.math3.stat.inference.TestUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import base.BaseClass;
import testUtils.ElementUtil;
import testUtils.TestUtil;

public class MappingPage extends BaseClass {

	TestUtil tu = new TestUtil();
	ElementUtil utils = new ElementUtil(driver);

	public MappingPage() {
		PageFactory.initElements(driver, this);
	}

	By mappingBrowser = By.xpath("//input[@id='imgTemplate']");

	By popupSelect1st = By.xpath("//table[@id='gvBrowse']/tbody/tr[2]/td[1]");

	static By mappingsInPopup = By.xpath("//table[@id='gvBrowse']/tbody/tr");

	public static By getMappingsInPopup() {
		return mappingsInPopup;
	}

	static By nextpage = By.xpath("//div[@id='dynBrowPg']/table/tbody/tr/td[5]/input");

	public static By getNextpage() {
		return nextpage;
	}

	By popupFrame = By.xpath("//iframe[@id='popupFrameDraggable']");

	By logOff = By.xpath("//a[@id='hypDelegation']");

	By mappingSearchBox = By.xpath("//input[@id='browSearch']");

	By mappingSearchBtn = By.xpath("//input[@id='Search']");

	By pageHeader = By.xpath("//div[@id='pnlMain']/div/p");

	By exportBtn = By.xpath("//input[@id='BtnxmlExport']");

	By mappingSetting = By.xpath("//div[@id='imgHeading']");

	By logOut = By.xpath("//a[@id='hypLogin']");

	By popupCloseBtn = By.xpath("(//div[@id='popupControls'])[2]/img[@id='popCloseBox']");

	By deleteBtn = By.xpath("//input[@id='btnDelete']");

	By importBtn = By.xpath("//input[@id='BtnxmlImporta']");

	By mappingTemplateName = By.xpath("//input[@id='txtTemplateName']");

	By mappingSaveBtn = By.xpath("//input[@id='BtnXMLGenerate']");

	By sourceFileRadioBtn = By.xpath("//input[@id='rdoSourceFile']");

	By xmlRadioBtn = By.xpath("//input[@id='rdoSourceXML']");

	By xlsRadioBtn = By.xpath("//input[@id='rdoSourceXLS']");

	By csvTxtRadioBtn = By.xpath("//input[@id='rdoSourceCSV']");

	By pdfRadioBtn = By.xpath("//input[@id='rdoSourcePDF']");

	By jsonRadioBtn = By.xpath("//input[@id='rdoSourceJSON']");
	
	By jsonRadioTargetBtn = By.xpath("//input[@id='rdoTargetJSON']");
	
	By pdfRadioTargetBtn = By.xpath("//input[@id='rdoTargetPDF']");
	
	

	public TestUtil getTu() {
		return tu;
	}

	public By getJsonRadioTargetBtn() {
		return jsonRadioTargetBtn;
	}

	public By getPdfRadioTargetBtn() {
		return pdfRadioTargetBtn;
	}

	public By getSourceBtn() {
		return sourceBtn;
	}

	public By getEntityBtn() {
		return entityBtn;
	}

	public By getFormulaBtn() {
		return formulaBtn;
	}

	public By getFixedValueBtn() {
		return fixedValueBtn;
	}

	public By getSplitBtn() {
		return splitBtn;
	}

	public By getSplitFunction() {
		return splitFunction;
	}

	public By getSplitLengthTextBox() {
		return splitLengthTextBox;
	}

	public By getSplitStartAt() {
		return splitStartAt;
	}

	public By getSplitSeperator() {
		return splitSeperator;
	}

	public By getSplitIndex() {
		return splitIndex;
	}

	public By getMaskTextbox() {
		return maskTextbox;
	}

	public By getIgnoreTextbox() {
		return ignoreTextbox;
	}

	public By getLetterDisplay() {
		return letterDisplay;
	}

	public By getPosition() {
		return position;
	}

	public By getConditionCheckbox() {
		return conditionCheckbox;
	}

	public By getAndOrCondition() {
		return andOrCondition;
	}

	public By getCondition1SourcePath() {
		return condition1SourcePath;
	}

	public By getCondition2SourcePath() {
		return condition2SourcePath;
	}

	public By getCondition1() {
		return condition1;
	}

	public By getCondition2() {
		return condition2;
	}

	public By getCondition1Mask() {
		return condition1Mask;
	}

	public By getCondition2Mask() {
		return condition2Mask;
	}

	public By getCondition1SourceCompare() {
		return condition1SourceCompare;
	}

	public By getCondition2SourceCompare() {
		return condition2SourceCompare;
	}

	public By getCondition1Value() {
		return condition1Value;
	}

	public By getCondition2Value() {
		return condition2Value;
	}

	public By getConditionFunction() {
		return conditionFunction;
	}

	public By getConditionConstantValue() {
		return conditionConstantValue;
	}

	public By getEntityType() {
		return entityType;
	}

	public By getEntitySource() {
		return entitySource;
	}

	public By getEntityTarget() {
		return entityTarget;
	}

	public By getConditionNotSatisfied() {
		return conditionNotSatisfied;
	}

	public By getConditionSatisfied() {
		return conditionSatisfied;
	}

	public By getDynamicFields() {
		return dynamicFields;
	}

	public By getFetchRecursiveFields() {
		return fetchRecursiveFields;
	}

	public By getPrefix() {
		return prefix;
	}

	public By getMathematicalOrder() {
		return mathematicalOrder;
	}

	public By getAddValue() {
		return addValue;
	}

	public By getFormulaMask1() {
		return formulaMask1;
	}

	public By getFormulaMask2() {
		return formulaMask2;
	}

	public By getFormulaMask3() {
		return formulaMask3;
	}

	public By getFormulaMask4() {
		return formulaMask4;
	}

	public By getFormulaMask5() {
		return formulaMask5;
	}

	public By getFormulaMask6() {
		return formulaMask6;
	}

	public By getFormulaIgnore1() {
		return formulaIgnore1;
	}

	public By getFormulaIgnore2() {
		return formulaIgnore2;
	}

	public By getFormulaIgnore3() {
		return formulaIgnore3;
	}

	public By getFormulaIgnore4() {
		return formulaIgnore4;
	}

	public By getFormulaIgnore5() {
		return formulaIgnore5;
	}

	public By getFormulaIgnore6() {
		return formulaIgnore6;
	}

	public By getFormulaSource1() {
		return formulaSource1;
	}

	public By getFormulaEntity1() {
		return formulaEntity1;
	}

	public By getFormulaFixedValue1() {
		return formulaFixedValue1;
	}

	public By getFormulaSource2() {
		return formulaSource2;
	}

	public By getFormulaEntity2() {
		return formulaEntity2;
	}

	public By getFormulaFixedValue2() {
		return formulaFixedValue2;
	}

	public By getFormulaSource3() {
		return formulaSource3;
	}

	public By getFormulaEntity3() {
		return formulaEntity3;
	}

	public By getFormulaFixedValue3() {
		return formulaFixedValue3;
	}

	public By getFormulaSource4() {
		return formulaSource4;
	}

	public By getFormulaEntity4() {
		return formulaEntity4;
	}

	public By getFormulaFixedValue4() {
		return formulaFixedValue4;
	}

	public By getFormulaSource5() {
		return formulaSource5;
	}

	public By getFormulaEntity5() {
		return formulaEntity5;
	}

	public By getFormulaFixedValue5() {
		return formulaFixedValue5;
	}

	public By getFormulaSource6() {
		return formulaSource6;
	}

	public By getFormulaEntity6() {
		return formulaEntity6;
	}

	public By getFormulaFixedValue6() {
		return formulaFixedValue6;
	}

	public By getFormulaSplit2() {
		return formulaSplit2;
	}

	public By getFormulaSplit1() {
		return formulaSplit1;
	}

	public By getFormulaSplit3() {
		return formulaSplit3;
	}

	public By getFormulaSplit4() {
		return formulaSplit4;
	}

	public By getFormulaSplit5() {
		return formulaSplit5;
	}

	public By getFormulaSplit6() {
		return formulaSplit6;
	}

	public By getFormulaSplitFunction1() {
		return formulaSplitFunction1;
	}

	public By getFormulaSplitFunction2() {
		return formulaSplitFunction2;
	}

	public By getFormulaSplitFunction3() {
		return formulaSplitFunction3;
	}

	public By getFormulaSplitFunction4() {
		return formulaSplitFunction4;
	}

	public By getFormulaSplitFunction5() {
		return formulaSplitFunction5;
	}

	public By getFormulaSplitFunction6() {
		return formulaSplitFunction6;
	}

	public By getFormulaSplitLength1() {
		return formulaSplitLength1;
	}

	public By getFormulaSplitLength2() {
		return formulaSplitLength2;
	}

	public By getFormulaSplitLength3() {
		return formulaSplitLength3;
	}

	public By getFormulaSplitLength4() {
		return formulaSplitLength4;
	}

	public By getFormulaSplitLength5() {
		return formulaSplitLength5;
	}

	public By getFormulaSplitLength6() {
		return formulaSplitLength6;
	}

	public By getFormulaSplitStartAt1() {
		return formulaSplitStartAt1;
	}

	public By getFormulaSplitStartAt2() {
		return formulaSplitStartAt2;
	}

	public By getFormulaSplitStartAt3() {
		return formulaSplitStartAt3;
	}

	public By getFormulaSplitStartAt4() {
		return formulaSplitStartAt4;
	}

	public By getFormulaSplitStartAt5() {
		return formulaSplitStartAt5;
	}

	public By getFormulaSplitStartAt6() {
		return formulaSplitStartAt6;
	}

	public By getFormulaSplitSeperator1() {
		return formulaSplitSeperator1;
	}

	public By getFormulaSplitSeperator2() {
		return formulaSplitSeperator2;
	}

	public By getFormulaSplitSeperator3() {
		return formulaSplitSeperator3;
	}

	public By getFormulaSplitSeperator4() {
		return formulaSplitSeperator4;
	}

	public By getFormulaSplitSeperator5() {
		return formulaSplitSeperator5;
	}

	public By getFormulaSplitSeperator6() {
		return formulaSplitSeperator6;
	}

	public By getFormulaEntityDropdown1() {
		return formulaEntityDropdown1;
	}

	public By getFormulaEntityDropdown2() {
		return formulaEntityDropdown2;
	}

	public By getFormulaEntityDropdown4() {
		return formulaEntityDropdown4;
	}

	public By getFormulaEntityDropdown3() {
		return formulaEntityDropdown3;
	}

	public By getFormulaEntityDropdown5() {
		return formulaEntityDropdown5;
	}

	public By getFormulaEntityDropdown6() {
		return formulaEntityDropdown6;
	}

	public By getFormulaEntityType1() {
		return formulaEntityType1;
	}

	public By getFormulaEntityType2() {
		return formulaEntityType2;
	}

	public By getFormulaEntityType3() {
		return formulaEntityType3;
	}

	public By getFormulaEntityType4() {
		return formulaEntityType4;
	}

	public By getFormulaEntityType5() {
		return formulaEntityType5;
	}

	public By getFormulaEntityType6() {
		return formulaEntityType6;
	}

	public By getFormulaSourceField1() {
		return formulaSourceField1;
	}

	public By getFormulaSourceField2() {
		return formulaSourceField2;
	}

	public By getFormulaSourceField3() {
		return formulaSourceField3;
	}

	public By getFormulaSourceField4() {
		return formulaSourceField4;
	}

	public By getFormulaSourceField5() {
		return formulaSourceField5;
	}

	public By getFormulaSourceField6() {
		return formulaSourceField6;
	}

	public By getFormulaNotSatisfied1() {
		return formulaNotSatisfied1;
	}

	public By getFormulaNotSatisfied2() {
		return formulaNotSatisfied2;
	}

	public By getFormulaNotSatisfied3() {
		return formulaNotSatisfied3;
	}

	public By getFormulaNotSatisfied4() {
		return formulaNotSatisfied4;
	}

	public By getFormulaNotSatisfied5() {
		return formulaNotSatisfied5;
	}

	public By getFormulaNotSatisfied6() {
		return formulaNotSatisfied6;
	}

	public By getFormulaSatisfied1() {
		return formulaSatisfied1;
	}

	public By getFormulaSatisfied2() {
		return formulaSatisfied2;
	}

	public By getFormulaSatisfied3() {
		return formulaSatisfied3;
	}

	public By getFormulaSatisfied4() {
		return formulaSatisfied4;
	}

	public By getFormulaSatisfied5() {
		return formulaSatisfied5;
	}

	public By getFormulaSatisfied6() {
		return formulaSatisfied6;
	}

	public By getFormulaFixedValueTextbox1() {
		return formulaFixedValueTextbox1;
	}

	public By getFormulaFixedValueTextbox2() {
		return formulaFixedValueTextbox2;
	}

	public By getFormulaEntityTarget1() {
		return formulaEntityTarget1;
	}

	public By getFormulaFixedValueTextbox3() {
		return formulaFixedValueTextbox3;
	}

	public By getFormulaFixedValueTextbox4() {
		return formulaFixedValueTextbox4;
	}

	public By getFormulaFixedValueTextbox5() {
		return formulaFixedValueTextbox5;
	}

	public By getFormulaFixedValueTextbox6() {
		return formulaFixedValueTextbox6;
	}

	public String getText1() {
		return text1;
	}

	public String getText2() {
		return text2;
	}

	By targetSchemaRadioBtn = By.xpath("//input[@id='rdoTargetSchema']");
	
	By sourceSchemaRadioBtn = By.xpath("//input[@id='rdoSourceSchema']");
	
	

	public By getSourceSchemaRadioBtn() {
		return sourceSchemaRadioBtn;
	}

	By targetFileRadioBtn = By.xpath("//input[@id='rdoTargetFile']");

	By targetEntityRadioBtn = By.xpath("//input[@id='rdoTargetEntity']");

	By targetSOLRadioBtn = By.xpath("//input[@id='rdoTargetSol']");
	
	By SourceSOLRadioBtn = By.xpath("//input[@id='rdoSourceSol']");
	
	

	public By getSourceSOLRadioBtn() {
		return SourceSOLRadioBtn;
	}

	public By getTopicTargetType() {
		return topicTargetType;
	}

	By sourceUploadFile = By.xpath("//input[@id='btnSourceUploadFile']");
	
	By targetUploadFile = By.xpath("//input[@id='btnTargetUploadFile']");

	public By getTargetUploadFile() {
		return targetUploadFile;
	}

	By topicType = By.xpath("//select[@id='ddlTargetTopic']");
	
	By topicTargetType = By.xpath("//select[@id='ddlSourceTopic']");

	By completeBtn = By.xpath("//input[@id='btnAutoMapping']");

	By contractExpandBtn = By.xpath("//input[@id='btnExpandAll']");

	static By topicInMappingSchema = By.xpath("//div[@id='tvTarget']/table/tbody/tr/td[2]");

	static By nodesHeaderInMappingSchema = By.xpath("//div[@id='tvTargetn0Nodes']/table");

	By nodesTarget = By.xpath("//input[contains(@id,'tvTarget') and @type='checkbox']");

	By nodesSource = By.xpath("//input[contains(@id,'tvSource') and @type='checkbox']");

	By fieldSaveBtn = By.xpath("//input[@id='btnFieldSave']");

	public By getFieldSaveBtn() {
		return fieldSaveBtn;
	}

	public static By getTopicInMappingSchema() {
		return topicInMappingSchema;
	}

	public static By getNodesHeaderInMappingSchema() {
		return nodesHeaderInMappingSchema;
	}

	public By getNodesTarget() {
		return nodesTarget;
	}

	public By getNodesSource() {
		return nodesSource;
	}

	public By getContractExpandBtn() {
		return contractExpandBtn;
	}

	public By getCompleteBtn() {
		return completeBtn;
	}

	public By getTopicType() {
		return topicType;
	}

	public By getTargetSchemaRadioBtn() {
		return targetSchemaRadioBtn;
	}

	public By getTargetFileRadioBtn() {
		return targetFileRadioBtn;
	}

	public By getTargetEntityRadioBtn() {
		return targetEntityRadioBtn;
	}

	public By getTargetSOLRadioBtn() {
		return targetSOLRadioBtn;
	}

	public By getSourceUploadFile() {
		return sourceUploadFile;
	}

	public By getXmlRadioBtn() {
		return xmlRadioBtn;
	}

	public By getXlsRadioBtn() {
		return xlsRadioBtn;
	}

	public By getCsvTxtRadioBtn() {
		return csvTxtRadioBtn;
	}

	public By getPdfRadioBtn() {
		return pdfRadioBtn;
	}

	public By getJsonRadioBtn() {
		return jsonRadioBtn;
	}

	public By getSourceFileRadioBtn() {
		return sourceFileRadioBtn;
	}

	public By getMappingSaveBtn() {
		return mappingSaveBtn;
	}

	public By getMappingTemplateName() {
		return mappingTemplateName;
	}

	public By getImportBtn() {
		return importBtn;
	}

	public By getDeleteBtn() {
		return deleteBtn;
	}

	public By getPopupCloseBtn() {
		return popupCloseBtn;
	}

	public By getLogOut() {
		return logOut;
	}

	public By getLogOff() {
		return logOff;
	}

	public By getMappingSetting() {
		return mappingSetting;
	}

	public By getExportBtn() {
		return exportBtn;
	}

	public By getPageHeader() {
		return pageHeader;
	}

	public By getMappingSearchBox() {
		return mappingSearchBox;
	}

	public By getMappingSearchBtn() {
		return mappingSearchBtn;
	}

	public By getPopupSelect1st() {
		return popupSelect1st;
	}

	public By getPopupFrame() {
		return popupFrame;
	}

	public ElementUtil getUtils() {
		return utils;
	}

	public By getMappingBrowser() {
		return mappingBrowser;
	}

	By sourceBtn = By.xpath("//label[text()='Source' and @for='rdoSource']");
	
	By entityBtn = By.xpath("//label[text()='Entity' and @for='rdoFieldEntity']");
	
	By formulaBtn = By.xpath("//label[text()='Formula' and @for='rdoFieldFormula']");
	
	By fixedValueBtn = By.xpath("//label[text()='Fixed value' and @for='rdoFieldConstant']");
	
	By splitBtn = By.xpath("//input[@id='chksplit']");
	
	By splitFunction = By.xpath("//select[@id='ddlSplitfunction']");
	
	By splitLengthTextBox = By.xpath("//input[@id='txtFunctionlenOrInd']");
	
	By splitStartAt =By.xpath("//input[@id='txtFunctionstartAt']");
	
	By splitSeperator = By.xpath("//input[@id='txtFunctionSeperator']");
	
	By splitIndex = By.xpath("//input[@id='txtFunctionlenOrInd']");
			
	By maskTextbox = By.xpath("//input[@id='txtSourceMask']");
	
	By ignoreTextbox= By.xpath("//input[@id='txtSourceSupress']");
	
	By letterDisplay = By.xpath("//select[@id='ddlSourceCasingValue']");
	
	By position = By.xpath("//input[@id='txtSourceCasingPosition']");
	
	By conditionCheckbox = By.xpath("//input[@id='chkHasCondition']");
	
	By andOrCondition = By.xpath("//select[@id='ddlMainCondition']");
	
	By condition1SourcePath= By.xpath("//select[@id='ddlConditionSourceNodePath']");
	
	By condition2SourcePath = By.xpath("//select[@id='ddlConditionSourceNodePath2']");
	
	By condition1 = By.xpath("//select[@id='ddlSubCondition1']");
	
	By condition2 = By.xpath("//select[@id='ddlSubCondition2']");
	
	By condition1Mask = By.xpath("//input[@id='txtConditionMasker1']");
	
	By condition2Mask = By.xpath("//input[@id='txtConditionMasker2']");
	
	By condition1SourceCompare = By.xpath("//select[@id='ddlConditionSourceNodeXpath']");
	
	By condition2SourceCompare = By.xpath("//select[@id='ddlConditionSourceNodeXpath2']");
	
	By condition1Value = By.xpath("//input[@id='txtConditionValue']");
	
	By condition2Value = By.xpath("//input[@id='txtConditionValue2']");
	
	By conditionFunction = By.xpath("//select[@id='ddlConditionFunction']");
	
	By conditionConstantValue = By.xpath("//input[@id='txtConstantValue']");
	
	By entityDropdown = By.xpath("//select[@id='ddlFieldEntity']");//select[@id='ddlFieldEntity']
	
	By entityType = By.xpath("//select[@id='ddlFieldEntityType']");
	
	By entitySource = By.xpath("//select[@id='ddlSourceFieldProperty']");
	
	By entityTarget = By.xpath("//select[@id='ddlFieldProperty']");
	
	By conditionNotSatisfied = By.xpath("//select[@id='ddlSource1UseSourceValueInput']");
 
	//select[@id='ddlValueMultipleTimesSource1']
	By conditionSatisfied= By.xpath("//select[@id='ddlValueMultipleTimesSource1']");
	
	By dynamicFields = By.xpath("//input[@id='chkDynamicValueSource1']");
	
	By fetchRecursiveFields = By.xpath("//input[@id='ChkFetchRecursiveFields']");
	
	By prefix = By.xpath("//input[@id='txtPrefixProperty']");
	
	By mathematicalOrder = By.xpath("//input[@id='txtFormulaExpression']");
	
	By addValue = By.xpath("//input[@id='chkAddFormula']");
	
	By formulaMask1 = By.xpath("//input[@id='txtValue1Mask']");
	
	By formulaMask2 = By.xpath("//input[@id='txtValue2Mask']");
	
	By formulaMask3 = By.xpath("//input[@id='txtValue3Mask']");
	
	By formulaMask4 = By.xpath("//input[@id='txtValue4Mask']");
	
	By formulaMask5 = By.xpath("//input[@id='txtValue5Mask']");
	
	By formulaMask6 = By.xpath("//input[@id='txtValue6Mask']");
	
	By formulaIgnore1 = By.xpath("//input[@id='txtValue1Supress']");
	
	By formulaIgnore2 = By.xpath("//input[@id='txtValue2Supress']");
	
	By formulaIgnore3 = By.xpath("//input[@id='txtValue3Supress']");
	
	By formulaIgnore4 = By.xpath("//input[@id='txtValue4Supress']");
	
	By formulaIgnore5 = By.xpath("//input[@id='txtValue5Supress']");
	
	By formulaIgnore6 = By.xpath("//input[@id='txtValue6Supress']");
	
	By formulaSource1 = By.xpath("//input[@id='rdoFormulaSource']");
	
	By formulaEntity1 = By.xpath("//input[@id='rdoFormulaEntity']");
	
	By formulaFixedValue1= By.xpath("//input[@id='rdoFormulaConstant']");
	
	By formulaSource2 = By.xpath("//input[@id='rdoFormulaValue2Source']");
	
	By formulaEntity2 = By.xpath("//input[@id='rdoFormulaValue2Entity']");
	
	By formulaFixedValue2= By.xpath("//input[@id='rdoFormulaValue2Constant']");
	
	By formulaSource3 = By.xpath("//input[@id='rdoFormulaValue3Source']");
	
	By formulaEntity3 = By.xpath("//input[@id='rdoFormulaValue3Entity']");
	
	By formulaFixedValue3= By.xpath("//input[@id='rdoFormulaValue3Constant']");
	
	By formulaSource4 = By.xpath("//input[@id='rdoFormulaValue4Source']");
	
	By formulaEntity4 = By.xpath("//input[@id='rdoFormulaValue4Entity']");
	
	By formulaFixedValue4= By.xpath("//input[@id='rdoFormulaValue4Constant']");
	
	By formulaSource5 = By.xpath("//input[@id='rdoFormulaValue5Source']");
	
	By formulaEntity5 = By.xpath("//input[@id='rdoFormulaValue5Entity']");
	
	By formulaFixedValue5= By.xpath("//input[@id='rdoFormulaValue5Constant']");
	
	By formulaSource6 = By.xpath("//input[@id='rdoFormulaValue6Source']");
	
	By formulaEntity6 = By.xpath("//input[@id='rdoFormulaValue6Entity']");
	
	By formulaFixedValue6= By.xpath("//input[@id='rdoFormulaValue6Constant']");
	
	By formulaSplit2 = By.xpath("//input[@id='chkFormulasplitValue2']");
	
	By formulaSplit1 = By.xpath("//input[@id='chkFormulasplit']");
	
	By formulaSplit3 = By.xpath("//input[@id='chkFormulasplitValue3']");
	
	By formulaSplit4 = By.xpath("//input[@id='chkFormulasplitValue4']");
	
	By formulaSplit5 = By.xpath("//input[@id='chkFormulasplitValue5']");
	
	By formulaSplit6 = By.xpath("//input[@id='chkFormulasplitValue6']");
			
	By formulaSplitFunction1 = By.xpath("//select[@id='ddlFormulaSplitfunction']");
	
	By formulaSplitFunction2 = By.xpath("//select[@id='ddlFormulaSplitfunctionValue2']");
	
	By formulaSplitFunction3 = By.xpath("//select[@id='ddlFormulaSplitfunctionValue3']");
	
	By formulaSplitFunction4 = By.xpath("//select[@id='ddlFormulaSplitfunctionValue4']");
	
	By formulaSplitFunction5 = By.xpath("//select[@id='ddlFormulaSplitfunctionValue5']");
	
	By formulaSplitFunction6 = By.xpath("//select[@id='ddlFormulaSplitfunctionValue6']");
	
	By formulaSplitLength1 = By.xpath("//input[@id='txtFormulaFunctionlenOrInd']");
	
	By formulaSplitLength2 = By.xpath("//input[@id='txtFormulaFunctionlenOrIndValue2']");
	
	By formulaSplitLength3 = By.xpath("//input[@id='txtFormulaFunctionlenOrIndValue3']");
	
	By formulaSplitLength4 = By.xpath("//input[@id='txtFormulaFunctionlenOrIndValue4']");
	
	By formulaSplitLength5 = By.xpath("//input[@id='txtFormulaFunctionlenOrIndValue5']");
	
	By formulaSplitLength6 = By.xpath("//input[@id='txtFormulaFunctionlenOrIndValue6']");
	
	By formulaSplitStartAt1 = By.xpath("//input[@id='txtFormulaFunctionstartAt']");
	
	By formulaSplitStartAt2 = By.xpath("//input[@id='txtFormulaFunctionstartAtValue2']");
	
	By formulaSplitStartAt3 = By.xpath("//input[@id='txtFormulaFunctionstartAtValue3']");
	
	By formulaSplitStartAt4 = By.xpath("//input[@id='txtFormulaFunctionstartAtValue4']");
	
	By formulaSplitStartAt5 = By.xpath("//input[@id='txtFormulaFunctionstartAtValue5']");
	
	By formulaSplitStartAt6= By.xpath("//input[@id='txtFormulaFunctionstartAtValue6']");
	
	By formulaSplitSeperator1 = By.xpath("//input[@id='txtFormulaFunctionSeperator']");
	
	By formulaSplitSeperator2= By.xpath("//input[@id='txtFormulaFunctionSeperatorValue2']");
	
	By formulaSplitSeperator3= By.xpath("//input[@id='txtFormulaFunctionSeperatorValue3']");
	
	By formulaSplitSeperator4= By.xpath("//input[@id='txtFormulaFunctionSeperatorValue4']");
	
	By formulaSplitSeperator5= By.xpath("//input[@id='txtFormulaFunctionSeperatorValue5']");
	
	By formulaSplitSeperator6= By.xpath("//input[@id='txtFormulaFunctionSeperatorValue6']");
	
	By formulaEntityDropdown1 = By.xpath("//select[@id='ddlFormulaEntity']");
	//select[@id='ddlFormulaValue2Entity']
	By formulaEntityDropdown2 = By.xpath("//select[@id='ddlFormulaValue2Entity']"); 
	
	By formulaEntityDropdown4 = By.xpath("//select[@id='ddlFormulaValue4Entity']"); 
			
	By formulaEntityDropdown3 = By.xpath("//select[@id='ddlFormulaValue3Entity']"); 
	
	By formulaEntityDropdown5 = By.xpath("//select[@id='ddlFormulaValue5Entity']"); 
	
	By formulaEntityDropdown6 = By.xpath("//select[@id='ddlFormulaValue6Entity']"); 
	
	By formulaEntityType1 = By.xpath("//select[@id='ddlFormulaEntityType']");
	
	By formulaEntityType2 = By.xpath("//select[@id='ddlFormulaValue2EntityType']");
	
	By formulaEntityType3 = By.xpath("//select[@id='ddlFormulaValue3EntityType']");
	
	By formulaEntityType4 = By.xpath("//select[@id='ddlFormulaValue4EntityType']");
	
	By formulaEntityType5 = By.xpath("//select[@id='ddlFormulaValue5EntityType']");
	
	By formulaEntityType6 = By.xpath("//select[@id='ddlFormulaValue6EntityType']");
	
	By formulaSourceField1 = By.xpath("//select[@id='ddlFormulaSourceFieldProperty']");
	//select[@id='ddlFormulaValue2SourceFieldProperty']
	By formulaSourceField2 = By.xpath("//select[@id='ddlFormulaValue2SourceFieldProperty']");
	
	By formulaSourceField3 = By.xpath("//select[@id='ddlFormulaValue3SourceFieldProperty']");
	
	By formulaSourceField4 = By.xpath("//select[@id='ddlFormulaValue4SourceFieldProperty']");
	
	By formulaSourceField5 = By.xpath("//select[@id='ddlFormulaValue5SourceFieldProperty']");
	
	By formulaSourceField6 = By.xpath("//select[@id='ddlFormulaValue6SourceFieldProperty']");
	
	By formulaNotSatisfied1 = By.xpath("//select[@id='ddlSource1Formula1ValueUseSourceValueInput']");
	
	By formulaNotSatisfied2 = By.xpath("//select[@id='ddlSource1Formula2ValueUseSourceValueInput']");
	
	By formulaNotSatisfied3 = By.xpath("//select[@id='ddlSource1Formula3ValueUseSourceValueInput']");
	
	By formulaNotSatisfied4 = By.xpath("//select[@id='ddlSource1Formula4ValueUseSourceValueInput']");
	
	By formulaNotSatisfied5 = By.xpath("//select[@id='ddlSource1Formula5ValueUseSourceValueInput']");
	
	By formulaNotSatisfied6 = By.xpath("//select[@id='ddlSource1Formula6ValueUseSourceValueInput']");
	
	By formulaSatisfied1 = By.xpath("//select[@id='ddlValueMultipleTimesSource1Formula1']");
	
	By formulaSatisfied2 = By.xpath("//select[@id='ddlValueMultipleTimesSource1Formula2']");
	
	By formulaSatisfied3 = By.xpath("//select[@id='ddlValueMultipleTimesSource1Formula3']");
	
	By formulaSatisfied4 = By.xpath("//select[@id='ddlValueMultipleTimesSource1Formula4']");
	
	By formulaSatisfied5 = By.xpath("//select[@id='ddlValueMultipleTimesSource1Formula5']");
	
	By formulaSatisfied6 = By.xpath("//select[@id='ddlValueMultipleTimesSource1Formula6']");
	
	By formulaFixedValueTextbox1 = By.xpath("//select[@id='txtFormulaConstant']");
	
	By formulaFixedValueTextbox2 = By.xpath("//input[@id='txtFormulaValue2Constant']");
	
	By formulaEntityTarget1 = By.xpath("//select[@id='ddlFormulaProperty']");
	
	By formulaFixedValueTextbox3 = By.xpath("//input[@id='txtFormulaValue3Constant']");
	
	By formulaFixedValueTextbox4 = By.xpath("//input[@id='txtFormulaValue4Constant']");
	
	By formulaFixedValueTextbox5 = By.xpath("//input[@id='txtFormulaValue5Constant']");
	
	By formulaFixedValueTextbox6 = By.xpath("//input[@id='txtFormulaValue6Constant']");
	
	
	By fixedValueTextbox = By.xpath("//input[@id='txtFieldConstant']");
	
	By fixedValueCondition = By.xpath("//input[@id='chkHasCondition']");
	
	By fixedValueAndOr  = By.xpath("//select[@id='ddlMainCondition']");
	
	By fixedValueAlternativeValue = By.xpath("//input[@id='TxtAlternativeFixedValue']");
	
	By targetPrimaryKey = By.xpath("//input[@id='chkPrimary']");
	
	By targetMandatory = By.xpath("Chkmandatory");
	
	By targetMask = By.xpath("//input[@id='txtMask']");
	
	
	
	
	String text1, text2 = null;

	public void clickNodes(String targetNode, String SourceNode) throws IOException {

		List<WebElement> targetNodes = driver.findElements(nodesTarget);

		for (int i = 0; i < targetNodes.size(); i++) {
			
			WebElement node = targetNodes.get(i);
			WebElement node1 = node.findElement(By.xpath("following-sibling::*[1]"));
			try {
				text1 = node1.findElement(By.tagName("font")).getText();
			} catch (Exception e) {

			}
			

			WebElement node2 = node.findElement(By.xpath("ancestor::div[1]/preceding-sibling::*[1]"));
			WebElement precedingBody = node2.findElement(By.tagName("tbody"));
			WebElement precedingRow = precedingBody.findElement(By.tagName("tr"));
			List<WebElement> precedingNode = precedingRow.findElements(By.tagName("td"));
			

			if (precedingNode.get(precedingNode.size() - 1).getText().equalsIgnoreCase(targetNode.split("/")[0])) {

				if (text1.equalsIgnoreCase(targetNode.split("/")[1])) {
					targetNodes.get(i).click();
					System.out.println(targetNode.split("/")[0] + "-" + text1 + " is Clicked");
					break;
				}

			}

		}

		List<WebElement> sourceNodes = driver.findElements(nodesSource);

		for (int i = 0; i < sourceNodes.size(); i++) {
			
			WebElement node = sourceNodes.get(i);
			WebElement node1 = node.findElement(By.xpath("following-sibling::*[1]"));
			
			try {
				text2 = node1.findElement(By.tagName("font")).getText();
			} catch (Exception e) {

			}

			WebElement node2 = node.findElement(By.xpath("ancestor::div[1]/preceding-sibling::*[1]"));
			WebElement precedingBody = node2.findElement(By.tagName("tbody"));
			WebElement precedingRow = precedingBody.findElement(By.tagName("tr"));
			List<WebElement> precedingNode = precedingRow.findElements(By.tagName("td"));
			

			if (text2.split(" ")[0].equalsIgnoreCase(SourceNode)) {
				utils.scrollIntoView(sourceNodes.get(i));
				sourceNodes.get(i).click();
				System.out.println(text2 + " is Clicked");
				break;
			}

		}
		
		
	}
	
	public void clickTargetNodes(String targetNode, String SourceNode) throws IOException {

		
		List<WebElement> targetNodes = driver.findElements(nodesTarget);

		for (int i = 0; i < targetNodes.size(); i++) {
			
			WebElement node = targetNodes.get(i);
			WebElement node1 = node.findElement(By.xpath("following-sibling::*[1]"));
			
			try {
				text2 = node1.findElement(By.tagName("font")).getText();
			} catch (Exception e) {

			}

			WebElement node2 = node.findElement(By.xpath("ancestor::div[1]/preceding-sibling::*[1]"));
			WebElement precedingBody = node2.findElement(By.tagName("tbody"));
			WebElement precedingRow = precedingBody.findElement(By.tagName("tr"));
			List<WebElement> precedingNode = precedingRow.findElements(By.tagName("td"));
			

			if (text2.split(" ")[0].equalsIgnoreCase(targetNode)) {
				utils.scrollIntoView(targetNodes.get(i));
				targetNodes.get(i).click();
				System.out.println(text2 + " is Clicked");
				break;
			}

		}
		
		
		List<WebElement> sourceNodes = driver.findElements(nodesSource);

		for (int i = 0; i < sourceNodes.size(); i++) {
			
			WebElement node = sourceNodes.get(i);
			WebElement node1 = node.findElement(By.xpath("following-sibling::*[1]"));
			try {
				text1 = node1.findElement(By.tagName("font")).getText();
			} catch (Exception e) {

			}
			

			WebElement node2 = node.findElement(By.xpath("ancestor::div[1]/preceding-sibling::*[1]"));
			WebElement precedingBody = node2.findElement(By.tagName("tbody"));
			WebElement precedingRow = precedingBody.findElement(By.tagName("tr"));
			List<WebElement> precedingNode = precedingRow.findElements(By.tagName("td"));
			
			System.out.println(precedingNode.get(precedingNode.size() - 1).getText().split(" ")[0].equalsIgnoreCase(SourceNode.split("/")[0]));
			System.out.println(precedingNode.get(precedingNode.size() - 1).getText());
			System.out.println(SourceNode.split("/")[0]);
			if (precedingNode.get(precedingNode.size() - 1).getText().split(" ")[0].equalsIgnoreCase(SourceNode.split("/")[0])) {
				System.out.println(SourceNode.split("/")[1]);
				System.out.println(text1.split(" ")[0]);
				if (text1.split(" ")[0].equalsIgnoreCase(SourceNode.split("/")[1])) {
					sourceNodes.get(i).click();
					System.out.println(SourceNode.split("/")[0] + "-" + text1 + " is Clicked");
					break;
				}

			}

		}

	}
	
	public void clickProperties(String excelFile,String sheetName,int i,int j,String data) throws IOException {
		if (data.equalsIgnoreCase("Source")) {
			
			utils.waitForElementToBeClickable(sourceBtn, 30);
			utils.getElement(sourceBtn).click();
			
			 if (tu.getData("MappingCreation.xlsx", "Mapping", 1, (j+4)).equalsIgnoreCase("Split")&& tu.getData("MappingCreation.xlsx", "Mapping", i, (j+15)).equalsIgnoreCase("yes")) {
					try {
						
					utils.waitForElementToBeClickable(splitBtn, 30);
					utils.getElement(splitBtn).click();
					
					if (tu.getData("MappingCreation.xlsx", "Mapping", i, (j+5)).equalsIgnoreCase("Left")) {
						utils.doSelectValuesByVisibleText(splitFunction,tu.getData("MappingCreation.xlsx", "Mapping", i, (j+5)), tu.getData("MappingCreation.xlsx", "Mapping", i, (j+5)));
						utils.getElement(splitLengthTextBox).sendKeys(tu.getData("MappingCreation.xlsx", "Mapping", i, (j+6)));
					}else if (tu.getData("MappingCreation.xlsx", "Mapping", i, (j+5)).equalsIgnoreCase("Right")) {
						utils.doSelectValuesByVisibleText(splitFunction,tu.getData("MappingCreation.xlsx", "Mapping", i, (j+5)), tu.getData("MappingCreation.xlsx", "Mapping", i, (j+5)));
						utils.getElement(splitLengthTextBox).sendKeys(tu.getData("MappingCreation.xlsx", "Mapping", i, (j+6)));
					}else if (tu.getData("MappingCreation.xlsx", "Mapping", i, (j+5)).equalsIgnoreCase("Substring")) {
						utils.doSelectValuesByVisibleText(splitFunction,tu.getData("MappingCreation.xlsx", "Mapping", i, (j+5)), tu.getData("MappingCreation.xlsx", "Mapping", 2, (j+5)));
						utils.getElement(splitLengthTextBox).sendKeys(tu.getData("MappingCreation.xlsx", "Mapping", i, (j+6)));
						utils.getElement(splitStartAt).sendKeys(tu.getData("MappingCreation.xlsx", "Mapping", i, (j+7)));
					}else if (tu.getData("MappingCreation.xlsx", "Mapping", i, (j+5)).equalsIgnoreCase("Split")) {
						utils.doSelectValuesByVisibleText(splitFunction,tu.getData("MappingCreation.xlsx", "Mapping", i, (j+5)), tu.getData("MappingCreation.xlsx", "Mapping", 2, (j+5)));
						utils.getElement(splitSeperator).sendKeys(tu.getData("MappingCreation.xlsx", "Mapping", i, (j+8)));
						utils.getElement(splitIndex).sendKeys(tu.getData("MappingCreation.xlsx", "Mapping", i, (j+9)));
					}
					} catch (Exception e) {
						
					}
				
				}  if (tu.getData("MappingCreation.xlsx", "Mapping", 1, (j+10)).equalsIgnoreCase("Ignore")) {
					
					System.out.println("Ignore -"+tu.getData("MappingCreation.xlsx", "Mapping", i, (j+10)));
					utils.getElement(ignoreTextbox).sendKeys(tu.getData("MappingCreation.xlsx", "Mapping", i, (j+10)));
					
				} if (tu.getData("MappingCreation.xlsx", "Mapping", 1, (j+12)).equalsIgnoreCase("Position")){
					
					System.out.println("Position -"+tu.getData("MappingCreation.xlsx", "Mapping", i, (j+11)));
					utils.getElement(position).sendKeys(tu.getData("MappingCreation.xlsx", "Mapping", i, (j+11)));
				
				} if (tu.getData("MappingCreation.xlsx", "Mapping", 1, (j+11)).equalsIgnoreCase("Letterdisplay")) {
					
					if (tu.getData("MappingCreation.xlsx", "Mapping", i, (j+11)).equalsIgnoreCase("Upper case")) {
						
						System.out.println("Uppercase -"+tu.getData("MappingCreation.xlsx", "Mapping", i, (j+11)));
						utils.doSelectValuesByVisibleText(letterDisplay,tu.getData("MappingCreation.xlsx", "Mapping", i, (j+11)), tu.getData("MappingCreation.xlsx", "Mapping", i, (j+11)));
					
					}else if (tu.getData("MappingCreation.xlsx", "Mapping", i, (j+11)).equalsIgnoreCase("Lower case")) {
						
						System.out.println("lowerrcase -"+tu.getData("MappingCreation.xlsx", "Mapping", i, (j+11)));
						utils.doSelectValuesByVisibleText(letterDisplay,tu.getData("MappingCreation.xlsx", "Mapping", i, (j+11)), tu.getData("MappingCreation.xlsx", "Mapping", i, (j+11)));
					
					}
					
				} if (tu.getData("MappingCreation.xlsx", "Mapping", 1, (j+15)).equalsIgnoreCase("Condition") && tu.getData("MappingCreation.xlsx", "Mapping", i, (j+15)).equalsIgnoreCase("yes")) {
					
					utils.waitForElementToBeClickable(conditionCheckbox, 30);
					utils.getElement(conditionCheckbox).click();
					
					if (tu.getData("MappingCreation.xlsx", "Mapping", i, (j+17)).equalsIgnoreCase("Not equal to")) {
						
						System.out.println("Not equal to -"+tu.getData("MappingCreation.xlsx", "Mapping", i, (j+17)));
						utils.doSelectValuesByVisibleText(condition1,tu.getData("MappingCreation.xlsx", "Mapping", i, (j+17)), tu.getData("MappingCreation.xlsx", "Mapping", i, (j+17)));
					
					}else if (tu.getData("MappingCreation.xlsx", "Mapping", i, (j+17)).equalsIgnoreCase("Equal to")) {
						
						System.out.println("Equal to -"+tu.getData("MappingCreation.xlsx", "Mapping", i, (j+17)));
						utils.doSelectValuesByVisibleText(condition1,tu.getData("MappingCreation.xlsx", "Mapping", i, (j+17)), tu.getData("MappingCreation.xlsx", "Mapping", i, (j+17)));
					
					}else if (tu.getData("MappingCreation.xlsx", "Mapping", i, (j+17)).equalsIgnoreCase("Contains")) {
						
						System.out.println("Contains -"+tu.getData("MappingCreation.xlsx", "Mapping", i, (j+17)));
						utils.doSelectValuesByVisibleText(condition1,tu.getData("MappingCreation.xlsx", "Mapping", i, (j+17)), tu.getData("MappingCreation.xlsx", "Mapping", i, (j+17)));
					
					}else if (tu.getData("MappingCreation.xlsx", "Mapping", i, (j+17)).equalsIgnoreCase("Not contains")) {
						
						System.out.println("Not contains -"+tu.getData("MappingCreation.xlsx", "Mapping", i, (j+17)));
						utils.doSelectValuesByVisibleText(condition1,tu.getData("MappingCreation.xlsx", "Mapping", i, (j+17)), tu.getData("MappingCreation.xlsx", "Mapping", i, (j+17)));
					
					}else if (tu.getData("MappingCreation.xlsx", "Mapping", i, (j+17)).equalsIgnoreCase("Greater than")) {
						
						System.out.println("Greater than -"+tu.getData("MappingCreation.xlsx", "Mapping", i, (j+17)));
						utils.doSelectValuesByVisibleText(condition1,tu.getData("MappingCreation.xlsx", "Mapping", i, (j+17)), tu.getData("MappingCreation.xlsx", "Mapping", i, (j+17)));
					
					}else if (tu.getData("MappingCreation.xlsx", "Mapping", i, (j+17)).equalsIgnoreCase("Greater than or equal to")) {
						
						System.out.println("Greater than or equal to -"+tu.getData("MappingCreation.xlsx", "Mapping", i, (j+17)));
						utils.doSelectValuesByVisibleText(condition1,tu.getData("MappingCreation.xlsx", "Mapping", i, (j+17)), tu.getData("MappingCreation.xlsx", "Mapping", i, (j+17)));
					
					}
					else if (tu.getData("MappingCreation.xlsx", "Mapping", i, (j+17)).equalsIgnoreCase("Smaller than")) {
						
						System.out.println("Smaller than -"+tu.getData("MappingCreation.xlsx", "Mapping", i, (j+17)));
						utils.doSelectValuesByVisibleText(condition1,tu.getData("MappingCreation.xlsx", "Mapping", i, (j+17)), tu.getData("MappingCreation.xlsx", "Mapping", i, (j+17)));
					
					}else if (tu.getData("MappingCreation.xlsx", "Mapping", i, (j+17)).equalsIgnoreCase("Smaller than or equal to")) {
						
						System.out.println("Smaller than or equal to -"+tu.getData("MappingCreation.xlsx", "Mapping", i, (j+17)));
						utils.doSelectValuesByVisibleText(condition1,tu.getData("MappingCreation.xlsx", "Mapping", i, (j+17)), tu.getData("MappingCreation.xlsx", "Mapping", i, (j+17)));
					
					}else if (tu.getData("MappingCreation.xlsx", "Mapping", i, (j+17)).equalsIgnoreCase("Is empty")) {
						
						System.out.println("Is empty -"+tu.getData("MappingCreation.xlsx", "Mapping", i, (j+17)));
						utils.doSelectValuesByVisibleText(condition1,tu.getData("MappingCreation.xlsx", "Mapping", i, (j+17)), tu.getData("MappingCreation.xlsx", "Mapping", i, (j+17)));
					
					}
					
				}if (tu.getData("MappingCreation.xlsx", "Mapping", 1, (j+20)).equalsIgnoreCase("Value")) {
					
					System.out.println("value -"+tu.getData("MappingCreation.xlsx", "Mapping", i, (j+20)));
					utils.getElement(condition1Value).sendKeys(tu.getData("MappingCreation.xlsx", "Mapping", i, (j+20)));
				
				}if (tu.getData("MappingCreation.xlsx", "Mapping", 1, (j+29)).equalsIgnoreCase("ConditionFunction") && tu.getData("MappingCreation.xlsx", "Mapping", i, (j+15)).equalsIgnoreCase("yes")) {
					try {
						
						utils.doSelectValuesByVisibleText(conditionFunction,tu.getData("MappingCreation.xlsx", "Mapping", i, (j+29)), tu.getData("MappingCreation.xlsx", "Mapping", i, (j+29)));
					} catch (Exception e) {
						
					}
					
				
				}if (tu.getData("MappingCreation.xlsx", "Mapping", 1, (j+30)).equalsIgnoreCase("Constant Value") && tu.getData("MappingCreation.xlsx", "Mapping", i, (j+15)).equalsIgnoreCase("yes") && tu.getData("MappingCreation.xlsx", "Mapping", i, (j+29)).equalsIgnoreCase("Apply constant value")) {

					System.out.println("Constant Value -"+tu.getData("MappingCreation.xlsx", "Mapping", i, (j+30)));
					utils.getElement(conditionConstantValue).sendKeys(tu.getData("MappingCreation.xlsx", "Mapping", i, (j+30)));
				
				}if (tu.getData("MappingCreation.xlsx", "Mapping", 1, (j+19)).equalsIgnoreCase("Source compare(path)")&& tu.getData("MappingCreation.xlsx", "Mapping", i, (j+15)).equalsIgnoreCase("yes")) {
					
					List<WebElement> sourceNodes = driver.findElements(nodesSource);

					for (int k = 0; k < sourceNodes.size(); k++) {
						
						System.out.println("sourceNode-" + (k + 1));
						WebElement node = sourceNodes.get(k);
						WebElement node1 = node.findElement(By.xpath("following-sibling::*[1]"));
						
						try {
							
							text2 = node1.findElement(By.tagName("font")).getText();
							
						} catch (Exception e) {

						}

						WebElement node2 = node.findElement(By.xpath("ancestor::div[1]/preceding-sibling::*[1]"));
						WebElement precedingBody = node2.findElement(By.tagName("tbody"));
						WebElement precedingRow = precedingBody.findElement(By.tagName("tr"));
						List<WebElement> precedingNode = precedingRow.findElements(By.tagName("td"));
						

						if (text2.split(" ")[0].equalsIgnoreCase(tu.getData("MappingCreation.xlsx", "Mapping", i, (j+2)))) {
							utils.scrollIntoView(sourceNodes.get(k));
							sourceNodes.get(k).click();
							System.out.println(text2 + " is Clicked");
							break;
						}

					}
					
					utils.waitForElementToBeClickable(condition1SourceCompare, 30);
					utils.scrollIntoView(condition1SourceCompare);
					Select s  = new Select(driver.findElement(condition1SourceCompare));
					List<WebElement> options = s.getOptions();
					for (int k = 0; k <options.size(); k++) {
						String text = options.get(k).getText();
						String[] split = text.split("/");
						String node =split[split.length-1];
						if (node.equalsIgnoreCase(tu.getData("MappingCreation.xlsx", "Mapping", i, (j+19)))) {
							options.get(k).click();
							break;
						}
						}
						
					
					
				} if (tu.getData("MappingCreation.xlsx", "Mapping", 1, (j+31)).equalsIgnoreCase("Apply different source node")&& tu.getData("MappingCreation.xlsx", "Mapping", i, (j+15)).equalsIgnoreCase("yes")&& tu.getData("MappingCreation.xlsx", "Mapping", i, (j+29)).equalsIgnoreCase("Apply different source node")) {
					List<WebElement> sourceNodes = driver.findElements(nodesSource);

					for (int k = 0; k < sourceNodes.size(); k++) {
						
						
						WebElement node = sourceNodes.get(k);
						WebElement node1 = node.findElement(By.xpath("following-sibling::*[1]"));
						
						try {
							text2 = node1.findElement(By.tagName("font")).getText();
						} catch (Exception e) {

						}

						WebElement node2 = node.findElement(By.xpath("ancestor::div[1]/preceding-sibling::*[1]"));
						WebElement precedingBody = node2.findElement(By.tagName("tbody"));
						WebElement precedingRow = precedingBody.findElement(By.tagName("tr"));
						List<WebElement> precedingNode = precedingRow.findElements(By.tagName("td"));
						

						if (text2.split(" ")[0].equalsIgnoreCase(tu.getData("MappingCreation.xlsx", "Mapping", i, (j+31)))) {
							utils.scrollIntoView(sourceNodes.get(k));
							sourceNodes.get(k).click();
							System.out.println(text2 + " is Clicked");
							break;
						}

					}
					
					utils.waitForElementToBeClickable(condition1SourceCompare, 30);
					utils.scrollIntoView(condition1SourceCompare);
					Select s  = new Select(driver.findElement(condition1SourceCompare));
					List<WebElement> options = s.getOptions();
					for (int k = 0; k <options.size(); k++) {
						String text = options.get(k).getText();
						String[] split = text.split("/");
						String node =split[split.length-1];
						if (node.equalsIgnoreCase(tu.getData("MappingCreation.xlsx", "Mapping", i, (j+31)))) {
							options.get(k).click();
							break;
						}
						}
						
				}
			
			
			
		}else if (data.equalsIgnoreCase("Entity")) {
			
			utils.waitForElementToBeClickable(entityBtn, 30);
			utils.getElement(entityBtn).click();
			utils.waitForElementToBeClickable(entityDropdown, 30);
			
			 if (tu.getData("MappingCreation.xlsx", "Mapping", 1, (j+4)).equalsIgnoreCase("Split")&& tu.getData("MappingCreation.xlsx", "Mapping", i, (j+15)).equalsIgnoreCase("yes")) {
					try {
						
					utils.waitForElementToBeClickable(splitBtn, 30);
					utils.getElement(splitBtn).click();
					
					if (tu.getData("MappingCreation.xlsx", "Mapping", i, (j+5)).equalsIgnoreCase("Left")) {
						utils.doSelectValuesByVisibleText(splitFunction,tu.getData("MappingCreation.xlsx", "Mapping", i, (j+5)), tu.getData("MappingCreation.xlsx", "Mapping", i, (j+5)));
						utils.getElement(splitLengthTextBox).sendKeys(tu.getData("MappingCreation.xlsx", "Mapping", i, (j+6)));
					}else if (tu.getData("MappingCreation.xlsx", "Mapping", i, (j+5)).equalsIgnoreCase("Right")) {
						utils.doSelectValuesByVisibleText(splitFunction,tu.getData("MappingCreation.xlsx", "Mapping", i, (j+5)), tu.getData("MappingCreation.xlsx", "Mapping", i, (j+5)));
						utils.getElement(splitLengthTextBox).sendKeys(tu.getData("MappingCreation.xlsx", "Mapping", i, (j+6)));
					}else if (tu.getData("MappingCreation.xlsx", "Mapping", i, (j+5)).equalsIgnoreCase("Substring")) {
						utils.doSelectValuesByVisibleText(splitFunction,tu.getData("MappingCreation.xlsx", "Mapping", i, (j+5)), tu.getData("MappingCreation.xlsx", "Mapping", 2, (j+5)));
						utils.getElement(splitLengthTextBox).sendKeys(tu.getData("MappingCreation.xlsx", "Mapping", i, (j+6)));
						utils.getElement(splitStartAt).sendKeys(tu.getData("MappingCreation.xlsx", "Mapping", i, (j+7)));
					}else if (tu.getData("MappingCreation.xlsx", "Mapping", i, (j+5)).equalsIgnoreCase("Split")) {
						utils.doSelectValuesByVisibleText(splitFunction,tu.getData("MappingCreation.xlsx", "Mapping", i, (j+5)), tu.getData("MappingCreation.xlsx", "Mapping", 2, (j+5)));
						utils.getElement(splitSeperator).sendKeys(tu.getData("MappingCreation.xlsx", "Mapping", i, (j+8)));
						utils.getElement(splitIndex).sendKeys(tu.getData("MappingCreation.xlsx", "Mapping", i, (j+9)));
					}
					} catch (Exception e) {
						
					}
				
				}  if (tu.getData("MappingCreation.xlsx", "Mapping", 1, (j+10)).equalsIgnoreCase("Ignore")) {
					
					System.out.println("Ignore -"+tu.getData("MappingCreation.xlsx", "Mapping", i, (j+10)));
					utils.getElement(ignoreTextbox).sendKeys(tu.getData("MappingCreation.xlsx", "Mapping", i, (j+10)));
					
				}  if (tu.getData("MappingCreation.xlsx", "Mapping", 1, (j+11)).equalsIgnoreCase("Letterdisplay")) {
					
					if (tu.getData("MappingCreation.xlsx", "Mapping", i, (j+11)).equalsIgnoreCase("Upper case")) {
						
						System.out.println("Uppercase -"+tu.getData("MappingCreation.xlsx", "Mapping", i, (j+11)));
						utils.doSelectValuesByVisibleText(letterDisplay,tu.getData("MappingCreation.xlsx", "Mapping", i, (j+11)), tu.getData("MappingCreation.xlsx", "Mapping", i, (j+11)));
					
					}else if (tu.getData("MappingCreation.xlsx", "Mapping", i, (j+11)).equalsIgnoreCase("Lower case")) {
						
						System.out.println("lowerrcase -"+tu.getData("MappingCreation.xlsx", "Mapping", i, (j+11)));
						utils.doSelectValuesByVisibleText(letterDisplay,tu.getData("MappingCreation.xlsx", "Mapping", i, (j+11)), tu.getData("MappingCreation.xlsx", "Mapping", i, (j+11)));
					
					}
					
				}if (tu.getData("MappingCreation.xlsx", "Mapping", 1, (j+12)).equalsIgnoreCase("Position")){
					
					System.out.println("Position -"+tu.getData("MappingCreation.xlsx", "Mapping", i, (j+11)));
					utils.getElement(position).sendKeys(tu.getData("MappingCreation.xlsx", "Mapping", i, (j+11)));
				
				}if (tu.getData("MappingCreation.xlsx", "Mapping", 1, (j+12)).equalsIgnoreCase("Position")){
					
					System.out.println("Position -"+tu.getData("MappingCreation.xlsx", "Mapping", i, (j+11)));
					utils.getElement(position).sendKeys(tu.getData("MappingCreation.xlsx", "Mapping", i, (j+11)));
				
				}if (tu.getData("MappingCreation.xlsx", "Mapping", 1, (j+32)).equalsIgnoreCase("Entity")){
					
					System.out.println("Position -"+tu.getData("MappingCreation.xlsx", "Mapping", i, (j+32)));
					utils.doSelectValuesByVisibleText(entityDropdown, tu.getData("MappingCreation.xlsx", "Mapping", i, (j+32)), tu.getData("MappingCreation.xlsx", "Mapping", i, (j+32)));
					utils.waitForElementToBeClickable(entityType, 30);
				}if (tu.getData("MappingCreation.xlsx", "Mapping", 1, (j+33)).equalsIgnoreCase("Entity type")){
					
					System.out.println("Position -"+tu.getData("MappingCreation.xlsx", "Mapping", i, (j+33)));
					utils.doSelectValuesByVisibleText(entityType, tu.getData("MappingCreation.xlsx", "Mapping", i, (j+33)), tu.getData("MappingCreation.xlsx", "Mapping", i, (j+33)));
					utils.waitForElementToBeClickable(entitySource, 30);
				}if (tu.getData("MappingCreation.xlsx", "Mapping", 1, (j+34)).equalsIgnoreCase("Entity Source")){
					
					System.out.println("Position -"+tu.getData("MappingCreation.xlsx", "Mapping", i, (j+34)));
					utils.doSelectValuesByVisibleText(entitySource, tu.getData("MappingCreation.xlsx", "Mapping", i, (j+34)), tu.getData("MappingCreation.xlsx", "Mapping", i, (j+34)));
					utils.waitForElementToBeClickable(entityTarget, 30);
				}if (tu.getData("MappingCreation.xlsx", "Mapping", 1, (j+34)).equalsIgnoreCase("Entity Target")){
					
					System.out.println("Position -"+tu.getData("MappingCreation.xlsx", "Mapping", i, (j+34)));
					utils.doSelectValuesByVisibleText(entityTarget, tu.getData("MappingCreation.xlsx", "Mapping", i, (j+34)), tu.getData("MappingCreation.xlsx", "Mapping", i, (j+34)));
					utils.waitForElementToBeClickable(entityTarget, 30);
				}if (tu.getData("MappingCreation.xlsx", "Mapping", 1, (j+34)).equalsIgnoreCase("Entity Target")){
					
					System.out.println("Position -"+tu.getData("MappingCreation.xlsx", "Mapping", i, (j+34)));
					utils.doSelectValuesByVisibleText(entityTarget, tu.getData("MappingCreation.xlsx", "Mapping", i, (j+34)), tu.getData("MappingCreation.xlsx", "Mapping", i, (j+34)));
					utils.waitForElementToBeClickable(entityTarget, 30);
				}if (tu.getData("MappingCreation.xlsx", "Mapping", 1, (j+35)).equalsIgnoreCase("In case condition(s) is/are not satisfied")){
					
					System.out.println("Position -"+tu.getData("MappingCreation.xlsx", "Mapping", i, (j+35)));
					utils.doSelectValuesByVisibleText(conditionNotSatisfied, tu.getData("MappingCreation.xlsx", "Mapping", i, (j+35)), tu.getData("MappingCreation.xlsx", "Mapping", i, (j+35)));
					
				}if (tu.getData("MappingCreation.xlsx", "Mapping", 1, (j+36)).equalsIgnoreCase("In case condition(s) is/are not satisfied more than once")){
					
					System.out.println("Position -"+tu.getData("MappingCreation.xlsx", "Mapping", i, (j+36)));
					utils.doSelectValuesByVisibleText(conditionNotSatisfied, tu.getData("MappingCreation.xlsx", "Mapping", i, (j+36)), tu.getData("MappingCreation.xlsx", "Mapping", i, (j+36)));
					
				}if (tu.getData("MappingCreation.xlsx", "Mapping", 1, (j+37)).equalsIgnoreCase("Use dynamic fields entity")){
					
					utils.getElement(dynamicFields).click();
					
				}if (tu.getData("MappingCreation.xlsx", "Mapping", 1, (j+38)).equalsIgnoreCase("Fetch recursive fields")){
					
					utils.getElement(fetchRecursiveFields).click();
					
				}if (tu.getData("MappingCreation.xlsx", "Mapping", 1, (j+39)).equalsIgnoreCase("Prefix")){
					utils.getElement(prefix).click();
				}
				
			
		} else if (data.equalsIgnoreCase("Formula")) {
			
			utils.waitForElementToBeClickable(formulaBtn, 30);
			utils.getElement(formulaBtn).click();
			
		} else if (data.equalsIgnoreCase("Fixed")) {
			
			utils.waitForElementToBeClickable(fixedValueBtn, 30);
			utils.getElement(fixedValueBtn).click();
			
		}

	}
	/*
	public void clickProperty(String excelFile,String sheetName,int i,int j,String data) throws IOException {
		
		  if (data.equalsIgnoreCase("Split")) {
			try {
				
			
			utils.waitForElementToBeClickable(splitBtn, 30);
			utils.getElement(splitBtn).click();
			
			if (tu.getData("MappingCreation.xlsx", "Mapping", i, (j+3)).equalsIgnoreCase("Left")) {
				utils.doSelectValuesByVisibleText(splitFunction,tu.getData("MappingCreation.xlsx", "Mapping", i, (j+3)), tu.getData("MappingCreation.xlsx", "Mapping", i, (j+3)));
			utils.getElement(splitLengthTextBox).sendKeys(tu.getData("MappingCreation.xlsx", "Mapping", i, (j+4)));
			}else if (tu.getData("MappingCreation.xlsx", "Mapping", i, (j+3)).equalsIgnoreCase("Right")) {
				utils.doSelectValuesByVisibleText(splitFunction,tu.getData("MappingCreation.xlsx", "Mapping", i, (j+3)), tu.getData("MappingCreation.xlsx", "Mapping", i, (j+3)));
				utils.getElement(splitLengthTextBox).sendKeys(tu.getData("MappingCreation.xlsx", "Mapping", i, (j+4)));
			}else if (tu.getData("MappingCreation.xlsx", "Mapping", i, (j+3)).equalsIgnoreCase("Substring")) {
				utils.doSelectValuesByVisibleText(splitFunction,tu.getData("MappingCreation.xlsx", "Mapping", i, (j+3)), tu.getData("MappingCreation.xlsx", "Mapping", 2, (j+3)));
				utils.getElement(splitLengthTextBox).sendKeys(tu.getData("MappingCreation.xlsx", "Mapping", i, (j+4)));
				utils.getElement(splitStartAt).sendKeys(tu.getData("MappingCreation.xlsx", "Mapping", i, (j+5)));
			}else if (tu.getData("MappingCreation.xlsx", "Mapping", i, (j+3)).equalsIgnoreCase("Split")) {
				utils.doSelectValuesByVisibleText(splitFunction,tu.getData("MappingCreation.xlsx", "Mapping", i, (j+3)), tu.getData("MappingCreation.xlsx", "Mapping", 2, (j+3)));
				utils.getElement(splitSeperator).sendKeys(tu.getData("MappingCreation.xlsx", "Mapping", i, (j+6)));
				utils.getElement(splitIndex).sendKeys(tu.getData("MappingCreation.xlsx", "Mapping", i, (j+7)));
			}
			} catch (Exception e) {
				
			}
		
		} else if (data.equalsIgnoreCase("Ignore")) {
			
			System.out.println("Ignore -"+tu.getData("MappingCreation.xlsx", "Mapping", i, (j+2)));
			utils.getElement(ignoreTextbox).sendKeys(tu.getData("MappingCreation.xlsx", "Mapping", i, (j+2)));
			
		}else if (data.equalsIgnoreCase("Position")){
			
			System.out.println("Position -"+tu.getData("MappingCreation.xlsx", "Mapping", i, (j+2)));
			utils.getElement(position).sendKeys(tu.getData("MappingCreation.xlsx", "Mapping", i, (j+2)));
		
		}else if (data.equalsIgnoreCase("Letterdisplay")) {
			
			if (tu.getData("MappingCreation.xlsx", "Mapping", i, (j+3)).equalsIgnoreCase("Upper case")) {
				
				System.out.println("Uppercase -"+tu.getData("MappingCreation.xlsx", "Mapping", i, (j+2)));
				utils.doSelectValuesByVisibleText(letterDisplay,tu.getData("MappingCreation.xlsx", "Mapping", i, (j+2)), tu.getData("MappingCreation.xlsx", "Mapping", i, (j+2)));
			
			}else if (tu.getData("MappingCreation.xlsx", "Mapping", i, (j+3)).equalsIgnoreCase("Lower case")) {
				
				System.out.println("lowerrcase -"+tu.getData("MappingCreation.xlsx", "Mapping", i, (j+2)));
				utils.doSelectValuesByVisibleText(letterDisplay,tu.getData("MappingCreation.xlsx", "Mapping", i, (j+2)), tu.getData("MappingCreation.xlsx", "Mapping", i, (j+2)));
			
			}
			
		}else if (data.equalsIgnoreCase("Condition")) {
			
			utils.waitForElementToBeClickable(conditionCheckbox, 30);
			utils.getElement(conditionCheckbox).click();
			
			if (tu.getData("MappingCreation.xlsx", "Mapping", i, (j+5)).equalsIgnoreCase("Not equal to")) {
				
				System.out.println("Not equal to -"+tu.getData("MappingCreation.xlsx", "Mapping", i, (j+5)));
				utils.doSelectValuesByVisibleText(condition1,tu.getData("MappingCreation.xlsx", "Mapping", i, (j+5)), tu.getData("MappingCreation.xlsx", "Mapping", i, (j+5)));
			
			}else if (tu.getData("MappingCreation.xlsx", "Mapping", i, (j+5)).equalsIgnoreCase("Equal to")) {
				
				System.out.println("Equal to -"+tu.getData("MappingCreation.xlsx", "Mapping", i, (j+5)));
				utils.doSelectValuesByVisibleText(condition1,tu.getData("MappingCreation.xlsx", "Mapping", i, (j+5)), tu.getData("MappingCreation.xlsx", "Mapping", i, (j+5)));
			
			}else if (tu.getData("MappingCreation.xlsx", "Mapping", i, (j+5)).equalsIgnoreCase("Contains")) {
				
				System.out.println("Contains -"+tu.getData("MappingCreation.xlsx", "Mapping", i, (j+5)));
				utils.doSelectValuesByVisibleText(condition1,tu.getData("MappingCreation.xlsx", "Mapping", i, (j+5)), tu.getData("MappingCreation.xlsx", "Mapping", i, (j+5)));
			
			}else if (tu.getData("MappingCreation.xlsx", "Mapping", i, (j+5)).equalsIgnoreCase("Not contains")) {
				
				System.out.println("Not contains -"+tu.getData("MappingCreation.xlsx", "Mapping", i, (j+5)));
				utils.doSelectValuesByVisibleText(condition1,tu.getData("MappingCreation.xlsx", "Mapping", i, (j+5)), tu.getData("MappingCreation.xlsx", "Mapping", i, (j+5)));
			
			}else if (tu.getData("MappingCreation.xlsx", "Mapping", i, (j+5)).equalsIgnoreCase("Greater than")) {
				
				System.out.println("Greater than -"+tu.getData("MappingCreation.xlsx", "Mapping", i, (j+5)));
				utils.doSelectValuesByVisibleText(condition1,tu.getData("MappingCreation.xlsx", "Mapping", i, (j+5)), tu.getData("MappingCreation.xlsx", "Mapping", i, (j+5)));
			
			}else if (tu.getData("MappingCreation.xlsx", "Mapping", i, (j+5)).equalsIgnoreCase("Greater than or equal to")) {
				
				System.out.println("Greater than or equal to -"+tu.getData("MappingCreation.xlsx", "Mapping", i, (j+5)));
				utils.doSelectValuesByVisibleText(condition1,tu.getData("MappingCreation.xlsx", "Mapping", i, (j+5)), tu.getData("MappingCreation.xlsx", "Mapping", i, (j+5)));
			
			}
			else if (tu.getData("MappingCreation.xlsx", "Mapping", i, (j+5)).equalsIgnoreCase("Smaller than")) {
				
				System.out.println("Smaller than -"+tu.getData("MappingCreation.xlsx", "Mapping", i, (j+5)));
				utils.doSelectValuesByVisibleText(condition1,tu.getData("MappingCreation.xlsx", "Mapping", i, (j+5)), tu.getData("MappingCreation.xlsx", "Mapping", i, (j+5)));
			
			}else if (tu.getData("MappingCreation.xlsx", "Mapping", i, (j+5)).equalsIgnoreCase("Smaller than or equal to")) {
				
				System.out.println("Smaller than or equal to -"+tu.getData("MappingCreation.xlsx", "Mapping", i, (j+5)));
				utils.doSelectValuesByVisibleText(condition1,tu.getData("MappingCreation.xlsx", "Mapping", i, (j+5)), tu.getData("MappingCreation.xlsx", "Mapping", i, (j+5)));
			
			}else if (tu.getData("MappingCreation.xlsx", "Mapping", i, (j+5)).equalsIgnoreCase("Is empty")) {
				
				System.out.println("Is empty -"+tu.getData("MappingCreation.xlsx", "Mapping", i, (j+5)));
				utils.doSelectValuesByVisibleText(condition1,tu.getData("MappingCreation.xlsx", "Mapping", i, (j+5)), tu.getData("MappingCreation.xlsx", "Mapping", i, (j+5)));
			
			}
			
		}else if (data.equalsIgnoreCase("Value")) {
			
			System.out.println("value -"+tu.getData("MappingCreation.xlsx", "Mapping", i, (j+2)));
			utils.getElement(condition1Value).sendKeys(tu.getData("MappingCreation.xlsx", "Mapping", i, (j+2)));
		
		}else if (data.equalsIgnoreCase("ConditionFunction")) {
			try {
				
				utils.doSelectValuesByVisibleText(conditionFunction,tu.getData("MappingCreation.xlsx", "Mapping", i, (j+2)), tu.getData("MappingCreation.xlsx", "Mapping", i, (j+2)));
			} catch (Exception e) {
				
			}
			
		
		}else if (data.equalsIgnoreCase("Constant Value")) {

			System.out.println("Constant Value -"+tu.getData("MappingCreation.xlsx", "Mapping", i, (j+2)));
			utils.getElement(conditionConstantValue).sendKeys(tu.getData("MappingCreation.xlsx", "Mapping", i, (j+2)));
		
		}else if (data.equalsIgnoreCase("Source compare(path)")) {
			
			List<WebElement> sourceNodes = driver.findElements(nodesSource);

			for (int k = 0; k < sourceNodes.size(); k++) {
				
				System.out.println("sourceNode-" + (k + 1));
				WebElement node = sourceNodes.get(k);
				WebElement node1 = node.findElement(By.xpath("following-sibling::*[1]"));
				
				try {
					
					text2 = node1.findElement(By.tagName("font")).getText();
					
				} catch (Exception e) {

				}

				WebElement node2 = node.findElement(By.xpath("ancestor::div[1]/preceding-sibling::*[1]"));
				WebElement precedingBody = node2.findElement(By.tagName("tbody"));
				WebElement precedingRow = precedingBody.findElement(By.tagName("tr"));
				List<WebElement> precedingNode = precedingRow.findElements(By.tagName("td"));
				

				if (text2.split(" ")[0].equalsIgnoreCase(tu.getData("MappingCreation.xlsx", "Mapping", i, (j+2)))) {
					utils.scrollIntoView(sourceNodes.get(k));
					sourceNodes.get(k).click();
					System.out.println(text2 + " is Clicked");
					break;
				}

			}
			
			utils.waitForElementToBeClickable(condition1SourceCompare, 30);
			utils.scrollIntoView(condition1SourceCompare);
			Select s  = new Select(driver.findElement(condition1SourceCompare));
			List<WebElement> options = s.getOptions();
			for (int k = 0; k <options.size(); k++) {
				String text = options.get(k).getText();
				String[] split = text.split("/");
				String node =split[split.length-1];
				if (node.equalsIgnoreCase(tu.getData("MappingCreation.xlsx", "Mapping", i, (j+2)))) {
					options.get(k).click();
					break;
				}
				}
				
			
			
		}else if (data.equalsIgnoreCase("Apply different source node")) {
			List<WebElement> sourceNodes = driver.findElements(nodesSource);

			for (int k = 0; k < sourceNodes.size(); k++) {
				
				
				WebElement node = sourceNodes.get(k);
				WebElement node1 = node.findElement(By.xpath("following-sibling::*[1]"));
				
				try {
					text2 = node1.findElement(By.tagName("font")).getText();
				} catch (Exception e) {

				}

				WebElement node2 = node.findElement(By.xpath("ancestor::div[1]/preceding-sibling::*[1]"));
				WebElement precedingBody = node2.findElement(By.tagName("tbody"));
				WebElement precedingRow = precedingBody.findElement(By.tagName("tr"));
				List<WebElement> precedingNode = precedingRow.findElements(By.tagName("td"));
				

				if (text2.split(" ")[0].equalsIgnoreCase(tu.getData("MappingCreation.xlsx", "Mapping", i, (j+2)))) {
					utils.scrollIntoView(sourceNodes.get(k));
					sourceNodes.get(k).click();
					System.out.println(text2 + " is Clicked");
					break;
				}

			}
			
			utils.waitForElementToBeClickable(condition1SourceCompare, 30);
			utils.scrollIntoView(condition1SourceCompare);
			Select s  = new Select(driver.findElement(condition1SourceCompare));
			List<WebElement> options = s.getOptions();
			for (int k = 0; k <options.size(); k++) {
				String text = options.get(k).getText();
				String[] split = text.split("/");
				String node =split[split.length-1];
				if (node.equalsIgnoreCase(tu.getData("MappingCreation.xlsx", "Mapping", i, (j+2)))) {
					options.get(k).click();
					break;
				}
				}
				
		}else if (data.equalsIgnoreCase("Entity")) {
			System.out.println(tu.getData("MappingCreation.xlsx", "Mapping", i, (j+2)));
			try {
				
				utils.doSelectValuesByVisibleText(entityDropdown, tu.getData("MappingCreation.xlsx", "Mapping", i, (j+2)), tu.getData("MappingCreation.xlsx", "Mapping", i, (j+2)));
				utils.waitForElementToBeClickable(entityType, 30);
			} catch (Exception e) {
				System.out.println("Couldn't proceed");
			}
			
			
		}else if (data.equalsIgnoreCase("Entity type")) {
			System.out.println(tu.getData("MappingCreation.xlsx", "Mapping", i, (j+2)));
			try {
				
				utils.doSelectValuesByVisibleText(entityType, tu.getData("MappingCreation.xlsx", "Mapping", i, (j+2)), tu.getData("MappingCreation.xlsx", "Mapping", i, (j+2)));
//				utils.waitForElementToBeClickable(entitySource, 20);
			} catch (Exception e) {
				System.out.println("Couldn't proceed");
			}
			
		}else if (data.equalsIgnoreCase("Entity Source")) {
			System.out.println(tu.getData("MappingCreation.xlsx", "Mapping", i, (j+2)));
			try{
			
				utils.doSelectValuesByVisibleText(entitySource, tu.getData("MappingCreation.xlsx", "Mapping", i, (j+2)), tu.getData("MappingCreation.xlsx", "Mapping", i, (j+2)));
//				utils.waitForElementToBeClickable(entityTarget, 20);
			} catch (Exception e) {
			
			}
			
			
		}else if (data.equalsIgnoreCase("Entity Target")) {
			System.out.println(tu.getData("MappingCreation.xlsx", "Mapping", i, (j+2)));
			try {
				
				utils.doSelectValuesByVisibleText(entityTarget, tu.getData("MappingCreation.xlsx", "Mapping", i, (j+2)), tu.getData("MappingCreation.xlsx", "Mapping", i, (j+2)));
//				utils.waitForElementToBeClickable(conditionNotSatisfied, 20);
			} catch (Exception e) {
			
			}
			
			
		}else if (data.equalsIgnoreCase("In case condition(s) is/are not satisfied")) {
			try {
				
				utils.doSelectValuesByVisibleText(conditionNotSatisfied, tu.getData("MappingCreation.xlsx", "Mapping", i, (j+2)), tu.getData("MappingCreation.xlsx", "Mapping", i, (j+2)));
//				utils.waitForElementToBeClickable(conditionSatisfied, 20);
			} catch (Exception e) {
				
			}
			
			
		}else if (data.equalsIgnoreCase("In case condition(s) is/are not satisfied more than once")) {
			try {
			
				utils.doSelectValuesByVisibleText(conditionSatisfied, tu.getData("MappingCreation.xlsx", "Mapping", i, (j+2)), tu.getData("MappingCreation.xlsx", "Mapping", i, (j+2)));
			
			} catch (Exception e) {
				
			}
			
		}else if (data.equalsIgnoreCase("Use dynamic fields entity")) {
			
//			utils.waitForElementToBeClickable(dynamicFields, 30);
			utils.getElement(dynamicFields).click();
			
		}else if (data.equalsIgnoreCase("Fetch recursive fields")) {
			
//			utils.waitForElementToBeClickable(fetchRecursiveFields, 30);
			utils.getElement(fetchRecursiveFields).click();
			
		}else if (data.equalsIgnoreCase("Prefix")) {
			
//			utils.waitForElementToBeClickable(prefix, 30);
			utils.getElement(prefix).click();
			
		}else if (data.equalsIgnoreCase("Mathematical order")) {
			
//			utils.waitForElementToBeClickable(mathematicalOrder, 30);
			utils.getElement(mathematicalOrder).sendKeys(tu.getData("MappingCreation.xlsx", "Mapping", i, (j+2)));
		
		}else if (data.equalsIgnoreCase("Add Value")) {
			try {
//				utils.waitForElementToBeClickable(addValue, 30);
				utils.getElement(addValue).click();
			} catch (Exception e) {
				// TODO: handle exception
			}
			
		
		}else if (data.equalsIgnoreCase("Mask1")) {
			try {
//				utils.waitForElementToBeClickable(formulaMask1, 30);
				utils.getElement(formulaMask1).sendKeys("");
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			
		}else if (data.equalsIgnoreCase("Ignore1")) {
			
			try {
//				utils.waitForElementToBeClickable(ignoreTextbox, 30);
				utils.getElement(ignoreTextbox).sendKeys("");
			} catch (Exception e) {
			
			}
			
			
		}else if (data.equalsIgnoreCase("Property1")) {
			
			try {
				if (tu.getData("MappingCreation.xlsx", "Mapping", i, (j+2)).equalsIgnoreCase("Source")) {
					
					
					utils.getElement(formulaSource1).click();
					
				}else if (tu.getData("MappingCreation.xlsx", "Mapping", i, (j+2)).equalsIgnoreCase("Entity")) {
					
//					utils.waitForElementToBeClickable(formulaEntity1, 30);
					utils.getElement(formulaEntity1).click();
					
				}else if (tu.getData("MappingCreation.xlsx", "Mapping", i, (j+2)).equalsIgnoreCase("Fixed value")) {
//					utils.waitForElementToBeClickable(formulaFixedValue1, 30);
					utils.getElement(formulaFixedValue1).click();
				}
			} catch (Exception e) {
				
			}
			
			
			
		}else  if (data.equalsIgnoreCase("Split1")) {
			
			try {
				
			
			utils.getElement(splitBtn).click();
			
			if (tu.getData("MappingCreation.xlsx", "Mapping", i, (j+3)).equalsIgnoreCase("Left")) {
				utils.doSelectValuesByVisibleText(formulaSplitFunction1,tu.getData("MappingCreation.xlsx", "Mapping", i, (j+3)), tu.getData("MappingCreation.xlsx", "Mapping", i, (j+3)));
				utils.getElement(formulaSplitLength1).sendKeys(tu.getData("MappingCreation.xlsx", "Mapping", i, (j+4)));
			}else if (tu.getData("MappingCreation.xlsx", "Mapping", i, (j+3)).equalsIgnoreCase("Right")) {
				utils.doSelectValuesByVisibleText(formulaSplitFunction1,tu.getData("MappingCreation.xlsx", "Mapping", i, (j+3)), tu.getData("MappingCreation.xlsx", "Mapping", i, (j+3)));
				utils.getElement(formulaSplitLength1).sendKeys(tu.getData("MappingCreation.xlsx", "Mapping", i, (j+4)));
			}else if (tu.getData("MappingCreation.xlsx", "Mapping", i, (j+3)).equalsIgnoreCase("Substring")) {
				utils.doSelectValuesByVisibleText(formulaSplitFunction1,tu.getData("MappingCreation.xlsx", "Mapping", i, (j+3)), tu.getData("MappingCreation.xlsx", "Mapping", 2, (j+3)));
				utils.getElement(formulaSplitLength1).sendKeys(tu.getData("MappingCreation.xlsx", "Mapping", i, (j+4)));
				utils.getElement(formulaSplitStartAt1).sendKeys(tu.getData("MappingCreation.xlsx", "Mapping", i, (j+5)));
			}else if (tu.getData("MappingCreation.xlsx", "Mapping", i, (j+3)).equalsIgnoreCase("Split")) {
				utils.doSelectValuesByVisibleText(formulaSplitFunction1,tu.getData("MappingCreation.xlsx", "Mapping", i, (j+3)), tu.getData("MappingCreation.xlsx", "Mapping", 2, (j+3)));
				utils.getElement(formulaSplitSeperator1).sendKeys(tu.getData("MappingCreation.xlsx", "Mapping", i, (j+6)));
				utils.getElement(formulaSplitLength1).sendKeys(tu.getData("MappingCreation.xlsx", "Mapping", i, (j+7)));
			}
			} catch (Exception e) {
				
			}
		
		}else if (data.equalsIgnoreCase("Entity 1")) {
			System.out.println("sfgdrfhdhdrg"+tu.getData("MappingCreation.xlsx", "Mapping", i, (j+2)));
			try {
				
				utils.doSelectValuesByVisibleText(formulaEntityDropdown1, tu.getData("MappingCreation.xlsx", "Mapping", i, (j+2)), tu.getData("MappingCreation.xlsx", "Mapping", i, (j+2)));
//				utils.waitForElementToBeClickable(formulaEntityType1, 20);
			} catch (Exception e) {
				System.out.println("Couldn't proceed");
			}
			
			
		}else if (data.equalsIgnoreCase("Entity type1")) {
			System.out.println("sfgdrfhdhdrg"+tu.getData("MappingCreation.xlsx", "Mapping", i, (j+2)));
			try {
				
				utils.doSelectValuesByVisibleText(formulaEntityType1, tu.getData("MappingCreation.xlsx", "Mapping", i, (j+2)), tu.getData("MappingCreation.xlsx", "Mapping", i, (j+2)));
//				utils.waitForElementToBeClickable(formulaSourceField1, 20);
			} catch (Exception e) {
				
			}
			
		}else if (data.equalsIgnoreCase("Entity Source1")) {
			System.out.println("sfgdrfhdhdrg"+tu.getData("MappingCreation.xlsx", "Mapping", i, (j+2)));
			try{
			
				utils.doSelectValuesByVisibleText(formulaSourceField1, tu.getData("MappingCreation.xlsx", "Mapping", i, (j+2)), tu.getData("MappingCreation.xlsx", "Mapping", i, (j+2)));
//				utils.waitForElementToBeClickable(formulaEntityTarget1, 20);
			} catch (Exception e) {
			
			}
			
			
		}else if (data.equalsIgnoreCase("Entity Target1")) {
			System.out.println("sfgdrfhdhdrg"+tu.getData("MappingCreation.xlsx", "Mapping", i, (j+2)));
			try {
				
				utils.doSelectValuesByVisibleText(formulaEntityTarget1, tu.getData("MappingCreation.xlsx", "Mapping", i, (j+2)), tu.getData("MappingCreation.xlsx", "Mapping", i, (j+2)));
//				utils.waitForElementToBeClickable(formulaNotSatisfied1, 20);
			} catch (Exception e) {
			
			}
			
			
		}else if (data.equalsIgnoreCase("In case condition(s) is/are not satisfied1")) {
			try {
				
				utils.doSelectValuesByVisibleText(formulaNotSatisfied1, tu.getData("MappingCreation.xlsx", "Mapping", i, (j+2)), tu.getData("MappingCreation.xlsx", "Mapping", i, (j+2)));
//				utils.waitForElementToBeClickable(formulaSatisfied1, 20);
			} catch (Exception e) {
				
			}
			
			
		}else if (data.equalsIgnoreCase("In case condition(s) is/are not satisfied more than once1")) {
			try {
			
				utils.doSelectValuesByVisibleText(formulaSatisfied1, tu.getData("MappingCreation.xlsx", "Mapping", i, (j+2)), tu.getData("MappingCreation.xlsx", "Mapping", i, (j+2)));
			
			} catch (Exception e) {
				
			}
			
		}else if (data.equalsIgnoreCase("Use dynamic fields entity1")) {
			
//			utils.waitForElementToBeClickable(dynamicFields, 30);
			utils.getElement(dynamicFields).click();
			
		}else if (data.equalsIgnoreCase("Fetch recursive fields1")) {
			
//			utils.waitForElementToBeClickable(fetchRecursiveFields, 30);
			utils.getElement(fetchRecursiveFields).click();
			
		}else if (data.equalsIgnoreCase("Fixed Value1")) {
//			utils.waitForElementToBeClickable(formulaFixedValue2, 30);
			utils.getElement(formulaFixedValue1).sendKeys(tu.getData("MappingCreation.xlsx", "Mapping", i, (j+2)));;
			
		}else if (data.equalsIgnoreCase("Mask2")) {
			
			utils.waitForElementToBeClickable(formulaMask2, 30);
			utils.getElement(formulaMask2).sendKeys("");
			
		}else if (data.equalsIgnoreCase("Ignore2")) {
			
			utils.waitForElementToBeClickable(ignoreTextbox, 30);
			utils.getElement(ignoreTextbox).sendKeys("");
			
		}else if (data.equalsIgnoreCase("Property2")) {
			try {
				if (tu.getData("MappingCreation.xlsx", "Mapping", i, (j+2)).equalsIgnoreCase("Source")) {
					
					utils.getElement(formulaSource2).click();
					
				}else if (tu.getData("MappingCreation.xlsx", "Mapping", i, (j+2)).equalsIgnoreCase("Entity")) {
					
					utils.waitForElementToBeClickable(formulaEntity2, 30);
					utils.getElement(formulaEntity2).click();
					
				}else if (tu.getData("MappingCreation.xlsx", "Mapping", i, (j+2)).equalsIgnoreCase("Fixed value")) {
				
					utils.waitForElementToBeClickable(formulaFixedValue2, 30);
					utils.getElement(formulaFixedValue2).click();
					
				}
			} catch (Exception e) {
				
			}
			
			
			
		}else  if (data.equalsIgnoreCase("Split2")) {
			
			try {
				
				utils.waitForElementToBeClickable(splitBtn, 30);
				utils.getElement(splitBtn).click();
				
				if (tu.getData("MappingCreation.xlsx", "Mapping", i, (j+3)).equalsIgnoreCase("Left")) {
					utils.doSelectValuesByVisibleText(formulaSplitFunction2,tu.getData("MappingCreation.xlsx", "Mapping", i, (j+3)), tu.getData("MappingCreation.xlsx", "Mapping", i, (j+3)));
					utils.getElement(formulaSplitLength2).sendKeys(tu.getData("MappingCreation.xlsx", "Mapping", i, (j+4)));
				}else if (tu.getData("MappingCreation.xlsx", "Mapping", i, (j+3)).equalsIgnoreCase("Right")) {
					utils.doSelectValuesByVisibleText(formulaSplitFunction2,tu.getData("MappingCreation.xlsx", "Mapping", i, (j+3)), tu.getData("MappingCreation.xlsx", "Mapping", i, (j+3)));
					utils.getElement(formulaSplitLength2).sendKeys(tu.getData("MappingCreation.xlsx", "Mapping", i, (j+4)));
				}else if (tu.getData("MappingCreation.xlsx", "Mapping", i, (j+3)).equalsIgnoreCase("Substring")) {
					utils.doSelectValuesByVisibleText(formulaSplitFunction2,tu.getData("MappingCreation.xlsx", "Mapping", i, (j+3)), tu.getData("MappingCreation.xlsx", "Mapping", 2, (j+3)));
					utils.getElement(formulaSplitLength2).sendKeys(tu.getData("MappingCreation.xlsx", "Mapping", i, (j+4)));
					utils.getElement(formulaSplitStartAt2).sendKeys(tu.getData("MappingCreation.xlsx", "Mapping", i, (j+5)));
				}else if (tu.getData("MappingCreation.xlsx", "Mapping", i, (j+3)).equalsIgnoreCase("Split")) {
					utils.doSelectValuesByVisibleText(formulaSplitFunction1,tu.getData("MappingCreation.xlsx", "Mapping", i, (j+3)), tu.getData("MappingCreation.xlsx", "Mapping", 2, (j+3)));
					utils.getElement(formulaSplitSeperator2).sendKeys(tu.getData("MappingCreation.xlsx", "Mapping", i, (j+6)));
					utils.getElement(formulaSplitLength2).sendKeys(tu.getData("MappingCreation.xlsx", "Mapping", i, (j+7)));
				}
				} catch (Exception e) {
					
				}
		
		}else if (data.equalsIgnoreCase("Entity 2")) {
			System.out.println(tu.getData("MappingCreation.xlsx", "Mapping", i, (j+2)));
			try {
				
				utils.doSelectValuesByVisibleText(formulaEntityDropdown2, tu.getData("MappingCreation.xlsx", "Mapping", i, (j+2)), tu.getData("MappingCreation.xlsx", "Mapping", i, (j+2)));
				utils.waitForElementToBeClickable(formulaEntityType2, 20);
				
			} catch (Exception e) {
				System.out.println("Couldn't proceed");
			}
			
			
		}else if (data.equalsIgnoreCase("Entity type2")) {
			System.out.println(tu.getData("MappingCreation.xlsx", "Mapping", i, (j+2)));
			try {
				
				utils.doSelectValuesByVisibleText(formulaEntityType2, tu.getData("MappingCreation.xlsx", "Mapping", i, (j+2)), tu.getData("MappingCreation.xlsx", "Mapping", i, (j+2)));
				utils.waitForElementToBeClickable(formulaSourceField2, 20);
			
			} catch (Exception e) {
				
			}
			
		}else if (data.equalsIgnoreCase("Entity Source2")) {
			System.out.println(tu.getData("MappingCreation.xlsx", "Mapping", i, (j+2)));
			try{
			
				utils.doSelectValuesByVisibleText(formulaSourceField2, tu.getData("MappingCreation.xlsx", "Mapping", i, (j+2)), tu.getData("MappingCreation.xlsx", "Mapping", i, (j+2)));
				
			} catch (Exception e) {
			
			}
			
			
		}else if (data.equalsIgnoreCase("Entity Target2")) {
			System.out.println(tu.getData("MappingCreation.xlsx", "Mapping", i, (j+2)));
			try {
				
				utils.doSelectValuesByVisibleText(entityTarget, tu.getData("MappingCreation.xlsx", "Mapping", i, (j+2)), tu.getData("MappingCreation.xlsx", "Mapping", i, (j+2)));
				utils.waitForElementToBeClickable(formulaNotSatisfied2, 20);
			
			} catch (Exception e) {
			
			}
			
			
		}else if (data.equalsIgnoreCase("In case condition(s) is/are not satisfied2")) {
			try {
				
				utils.doSelectValuesByVisibleText(formulaNotSatisfied2, tu.getData("MappingCreation.xlsx", "Mapping", i, (j+2)), tu.getData("MappingCreation.xlsx", "Mapping", i, (j+2)));
				utils.waitForElementToBeClickable(formulaSatisfied2, 20);
			
			} catch (Exception e) {
				
			}
			
			
		}else if (data.equalsIgnoreCase("In case condition(s) is/are not satisfied more than once2")) {
			try {
			
				utils.doSelectValuesByVisibleText(formulaSatisfied2, tu.getData("MappingCreation.xlsx", "Mapping", i, (j+2)), tu.getData("MappingCreation.xlsx", "Mapping", i, (j+2)));
			
			} catch (Exception e) {
				
			}
			
		}else if (data.equalsIgnoreCase("Use dynamic fields entity2")) {
			try {
				
				utils.waitForElementToBeClickable(dynamicFields, 30);
				utils.getElement(dynamicFields).click();
			
			} catch (Exception e) {
				
			}
			
			
		}else if (data.equalsIgnoreCase("Fetch recursive fields2")) {
			
			try {
				
				utils.waitForElementToBeClickable(fetchRecursiveFields, 30);
				utils.getElement(fetchRecursiveFields).click();
			
			} catch (Exception e) {
				
			}
			
			
		}else if (data.equalsIgnoreCase("Fixed Value2")) {
			System.out.println("dffgneorgne"+tu.getData("MappingCreation.xlsx", "Mapping", i, (j+2)));
			try {
				
				utils.waitForElementToBeClickable(formulaFixedValueTextbox2, 30);
				System.out.println(tu.getData("MappingCreation.xlsx", "Mapping", i, (j+2)));
				utils.getElement(formulaFixedValueTextbox2).sendKeys(tu.getData("MappingCreation.xlsx", "Mapping", i, (j+2)));;
			
			} catch (Exception e) {
				
			}
			
		}else if (data.equalsIgnoreCase("Fixed Value Entity")) {
			
			
			try {
				utils.getElement(fixedValueTextbox).sendKeys(tu.getData("MappingCreation.xlsx", "Mapping", i, (j+2)));
			} catch (Exception e) {
				// TODO: handle exception
			}
		}else if (data.equalsIgnoreCase("")) {
			
		}
		
		
		

	}
*/
	public By getEntityDropdown() {
		return entityDropdown;
	}

	public void setEntityDropdown(By entityDropdown) {
		this.entityDropdown = entityDropdown;
	}

}
