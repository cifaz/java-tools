package org.mybatis.generator.plugin;

import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.*;
import org.mybatis.generator.api.dom.xml.Attribute;
import org.mybatis.generator.api.dom.xml.Document;
import org.mybatis.generator.api.dom.xml.TextElement;
import org.mybatis.generator.api.dom.xml.XmlElement;

import java.util.List;

public class InsertBatchPlugin extends PluginAdapter {

    public InsertBatchPlugin() {
    }

    public boolean validate(List<String> warnings) {
        return true;
    }

    public boolean clientSelectByExampleWithBLOBsMethodGenerated(Method method, Interface interfaze, IntrospectedTable introspectedTable) {
        interfaze.addMethod(this.generateInsertBatch(method, introspectedTable));
        return true;
    }

    public boolean clientSelectByExampleWithoutBLOBsMethodGenerated(Method method, Interface interfaze, IntrospectedTable introspectedTable) {
        interfaze.addMethod(this.generateInsertBatch(method, introspectedTable));
        return true;
    }

    public boolean clientSelectByExampleWithBLOBsMethodGenerated(Method method, TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        topLevelClass.addMethod(this.generateInsertBatch(method, introspectedTable));
        return true;
    }

    public boolean clientSelectByExampleWithoutBLOBsMethodGenerated(Method method, TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        topLevelClass.addMethod(this.generateInsertBatch(method, introspectedTable));
        return true;
    }

    public boolean sqlMapDocumentGenerated(Document document, IntrospectedTable introspectedTable) {
        String tableName = introspectedTable.getAliasedFullyQualifiedTableNameAtRuntime();
        XmlElement parentElement = document.getRootElement();
        XmlElement insertBatchElement = new XmlElement("insert");
        insertBatchElement.addAttribute(new Attribute("id", "insertBatch"));
        insertBatchElement.addAttribute(new Attribute("parameterType", "java.util.List"));
        List<IntrospectedColumn> columns = introspectedTable.getAllColumns();
        StringBuffer tableColumn = new StringBuffer();
        StringBuffer javaType = new StringBuffer();

        for (int i = 0; i < columns.size(); ++i) {
            IntrospectedColumn column = (IntrospectedColumn) columns.get(i);
            if (i != 0) {
                tableColumn.append(",");
                javaType.append(",");
            }

            tableColumn.append(column.getActualColumnName());
            javaType.append("#{item." + column.getJavaProperty() + ",jdbcType=" + column.getJdbcTypeName() + "}");
        }

        insertBatchElement.addElement(new TextElement("insert into " + tableName + " (" + tableColumn.toString() + ") values  <foreach collection=\"records\" item=\"item\" index=\"index\" separator=\",\"> ( " + javaType.toString() + " )  </foreach>"));
        parentElement.addElement(insertBatchElement);
        return super.sqlMapDocumentGenerated(document, introspectedTable);
    }

    private Method generateInsertBatch(Method method, IntrospectedTable introspectedTable) {
        Method m = new Method("insertBatch");
        m.setVisibility(method.getVisibility());
        m.setReturnType(FullyQualifiedJavaType.getIntInstance());
        m.addParameter(new Parameter(new FullyQualifiedJavaType("java.util.List<" + introspectedTable.getBaseRecordType() + ">"), "records", "@Param(\"records\")"));
        this.context.getCommentGenerator().addGeneralMethodComment(m, introspectedTable);
        return m;
    }
}
