package by.bsuir.talakh.js_operator;

import by.bsuir.talakh.core.DaoFactory;
import by.bsuir.talakh.core.JspParameter;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class OperatorService {

    public List<Operator> takeOperatorList() {
        OperatorDao operatorDao = DaoFactory.getInstance().getOperatorDao();
        return operatorDao.takeAll();
    }

    public Operator takeOperator(String id) {
        OperatorDao operatorDao = DaoFactory.getInstance().getOperatorDao();
        return operatorDao.findById(Integer.parseInt(id));
    }

    public int addOperator(HttpServletRequest request) {
        String operatorSymbol = request.getParameter(JspParameter.OPERATOR_SYMBOL);
        String name = request.getParameter(JspParameter.ARTICLE_NAME);
        String description = request.getParameter(JspParameter.ARTICLE_DESCRIPTION);

        Operator operator = new Operator();
        operator.setDescription(description);
        operator.setName(name);
        operator.setOperatorSymbol(operatorSymbol);

        OperatorDao operatorDao = DaoFactory.getInstance().getOperatorDao();
        return operatorDao.addOperator(operator);
    }

    public void updateOperator(HttpServletRequest request) {
        String id = request.getParameter(JspParameter.ID);
        String description = request.getParameter(JspParameter.ARTICLE_DESCRIPTION);

        Operator operator = new Operator();
        operator.setDescription(description);
        operator.setId(Integer.parseInt(id));

        OperatorDao operatorDao = DaoFactory.getInstance().getOperatorDao();
        operatorDao.updateOperator(operator);
    }

    public void deleteOperator(HttpServletRequest request) {

        String id = request.getParameter(JspParameter.ID);
        OperatorDao operatorDao = DaoFactory.getInstance().getOperatorDao();
        operatorDao.deleteOperator(new Operator(Integer.parseInt(id)));
    }
}
