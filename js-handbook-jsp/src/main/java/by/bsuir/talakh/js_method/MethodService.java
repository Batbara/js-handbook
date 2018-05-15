package by.bsuir.talakh.js_method;

import by.bsuir.talakh.core.DaoFactory;
import by.bsuir.talakh.core.JspParameter;
import by.bsuir.talakh.js_object.JsObject;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class MethodService {
    public List<Method> takeMethodList(JsObject jsObject) {
        MethodDao methodDao = DaoFactory.getInstance().getMethodDao();
        return methodDao.takeAll(jsObject.getId());
    }

    public Method takeMethod(String id) {
        MethodDao methodDao = DaoFactory.getInstance().getMethodDao();
        return methodDao.findById(Integer.parseInt(id));
    }

    public int addMethod(HttpServletRequest request) {

        String objectId = request.getParameter(JspParameter.ID);
        String name = request.getParameter(JspParameter.ARTICLE_NAME);
        String description = request.getParameter(JspParameter.ARTICLE_DESCRIPTION);
        Method method = new Method();
        method.setMethodObject(new JsObject(Integer.parseInt(objectId)));
        method.setName(name);
        method.setDescription(description);

        MethodDao methodDao = DaoFactory.getInstance().getMethodDao();
        return methodDao.addMethod(method);
    }

    public void updateMethod(HttpServletRequest request) {
        String id = request.getParameter(JspParameter.ID);
        String description = request.getParameter(JspParameter.ARTICLE_DESCRIPTION);

        Method method = new Method();
        method.setId(Integer.parseInt(id));
        method.setDescription(description);

        MethodDao methodDao = DaoFactory.getInstance().getMethodDao();
        methodDao.updateMethod(method);
    }

    public void deleteMethod(HttpServletRequest request) {

        String id = request.getParameter(JspParameter.ID);
        MethodDao methodDao = DaoFactory.getInstance().getMethodDao();
        methodDao.deleteMethod(new Method(Integer.parseInt(id)));

    }
}
