package com.geo.geomantic.common.config;

import com.geo.geomantic.common.web.RedisRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.context.ApplicationContext;
import org.thymeleaf.context.ITemplateContext;
import org.thymeleaf.engine.AttributeName;
import org.thymeleaf.model.IModel;
import org.thymeleaf.model.IModelFactory;
import org.thymeleaf.model.IProcessableElementTag;
import org.thymeleaf.processor.element.AbstractAttributeTagProcessor;
import org.thymeleaf.processor.element.IElementTagStructureHandler;
import org.thymeleaf.spring5.context.SpringContextUtils;
import org.thymeleaf.templatemode.TemplateMode;
import org.unbescape.html.HtmlEscape;

import java.util.ArrayList;
import java.util.List;

import static com.geo.geomantic.common.config.ThymeleafFacade.evaluateAsStringsWithDelimiter;
import static com.geo.geomantic.common.config.ThymeleafFacade.getRawValue;


public class CustomerTagProcessor extends AbstractAttributeTagProcessor {

    private static final String DELIMITER = ",";
    private static final String ATTRIBUTE_NAME = "dict";// 标签名
    private static final int PRECEDENCE = 300;// 优先级

    //	查找字典数据
    private static final String GET_LABEL_BY_TYPE = "getLabel";
    //	根据id获取用户名
    private static final String USER_NAME_BY_TYPE = "getNameById";
    //	根据id获取手机号
    private static final String USER_PHONE_BY_TYPE = "getPhoneById";
    //	获取当前用户的id
    private static final String USER_ID_BY_TYPE = "getUserId";

    public CustomerTagProcessor(String dialectPrefix) {
        super(TemplateMode.HTML, // 此处理器将仅应用于HTML模式
                dialectPrefix, // 要应用于名称的匹配前缀
                null, // 标签名称：匹配此名称的特定标签
                false, // 将标签前缀应用于标签名称
                ATTRIBUTE_NAME, // 无属性名称：将通过标签名称匹配
                true, // 没有要应用于属性名称的前缀
                PRECEDENCE, true); // 优先(内部方言自己的优先)

    }

    /**
     * context 页面上下文 tag 标签
     * 获取标签内容表达式
     */
    @Override
    protected void doProcess(ITemplateContext context, IProcessableElementTag tag, AttributeName attributeName,
                             String attributeValue, IElementTagStructureHandler structureHandler) {
        final String rawValue = getRawValue(tag, attributeName);
        String type = null;
        String exper = null;
        if (StringUtils.isNotBlank(rawValue)) {
            String[] tmp = rawValue.split(":");

            if (tmp.length > 0 && StringUtils.isNotBlank(tmp[0])) {
                type = tmp[0];
            }
            if (tmp.length > 1 && StringUtils.isNotBlank(tmp[1])) {
                exper = tmp[1];
            }
        }

        // 通过IStandardExpression 解析器 解析表达式获取参数
        List<String> values = new ArrayList<>();
        if (StringUtils.isNotBlank(exper)) {
            values = evaluateAsStringsWithDelimiter(context, exper, DELIMITER);
        }
        // 标签名
        final String elementCompleteName = tag.getElementCompleteName();

        // 创建模型
        final IModelFactory modelFactory = context.getModelFactory();
        final IModel model = modelFactory.createModel();
        // 添加模型 标签
        model.add(modelFactory.createOpenElementTag(elementCompleteName));

        // 调用具体方法
        switch (type) {
            case GET_LABEL_BY_TYPE:
                // 去除html
                model.add(modelFactory.createText(HtmlEscape.escapeHtml5(getDictName(context, values))));
                break;
            case USER_NAME_BY_TYPE:
                model.add(modelFactory.createText(getNameById(context, values)));
                break;
            case USER_PHONE_BY_TYPE:
                model.add(modelFactory.createText(getPhoneById(context, values)));
                break;
            case USER_ID_BY_TYPE:
                model.add(modelFactory.createText(getUserId(context)));
                break;
            default:
                break;
        }

        // 添加模型 标签
        model.add(modelFactory.createCloseElementTag(elementCompleteName));
        // 替换页面标签
        structureHandler.replaceWith(model, false);
    }

    private String getDictName(ITemplateContext context, List<String> values) {
        ApplicationContext appCtx = SpringContextUtils.getApplicationContext(context);
        RedisRepository dic = appCtx.getBean(RedisRepository.class);
        String label = dic.getDictLabelByTypeAndValue(values.get(0), values.get(1));
        if (StringUtils.isBlank(label)) {
            label = "激活";
        }
        return label;
    }

    private String getNameById(ITemplateContext context, List<String> values) {
        return "";
    }

    private String getPhoneById(ITemplateContext context, List<String> values) {
        return "";
    }

    private String getUserId(ITemplateContext context) {
        return "";
    }


}
