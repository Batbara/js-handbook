package by.bsuir.talakh.config;

import by.bsuir.talakh.entity.JsObject;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class JsObjectConverter implements Converter<String, JsObject> {
    @Override
    public JsObject convert(String s) {
        JsObject jsObject = new JsObject();
        jsObject.setId(Integer.parseInt(s));
        return jsObject;
    }
}
