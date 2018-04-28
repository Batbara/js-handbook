package by.bsuir.talakh.js_object;

import by.bsuir.talakh.core.DaoFactory;
import by.bsuir.talakh.core.JspParameter;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class JsObjectService {
    public List<JsObject> takeJsObjectList() {
        JsObjectDao jsObjectDao = DaoFactory.getInstance().getJsObjectDao();
        return jsObjectDao.takeAll();
    }

    public JsObject takeJsObject(String id) {
        JsObjectDao jsObjectDao = DaoFactory.getInstance().getJsObjectDao();
        return jsObjectDao.findById(Integer.parseInt(id));
    }

    public int addJsObject(HttpServletRequest request) {
        String name = request.getParameter(JspParameter.ARTICLE_NAME);
        String description = request.getParameter(JspParameter.ARTICLE_DESCRIPTION);

        JsObject jsObject = new JsObject();
        jsObject.setName(name);
        jsObject.setDescription(description);

        JsObjectDao jsObjectDao = DaoFactory.getInstance().getJsObjectDao();
        return jsObjectDao.addObject(jsObject);
    }

    public void updateJsObject(HttpServletRequest request) {
        String id = request.getParameter(JspParameter.ID);
        String description = request.getParameter(JspParameter.ARTICLE_DESCRIPTION);

        JsObject jsObject = new JsObject();
        jsObject.setId(Integer.parseInt(id));
        jsObject.setDescription(description);

        JsObjectDao jsObjectDao = DaoFactory.getInstance().getJsObjectDao();
        jsObjectDao.updateObject(jsObject);
    }

    public void deleteJsObject(HttpServletRequest request) {

        String id = request.getParameter(JspParameter.ID);
        JsObjectDao jsObjectDao = DaoFactory.getInstance().getJsObjectDao();
        jsObjectDao.deleteObject(new JsObject(Integer.parseInt(id)));

    }
}
