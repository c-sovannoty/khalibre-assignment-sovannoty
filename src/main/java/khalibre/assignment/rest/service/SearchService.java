package khalibre.assignment.rest.service;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import com.khalibre.assignment.utils.HttpClientUtil;
import com.khalibre.assignment.utils.StringUtil;



@Path("/search")
public class SearchService {

	private String PARA_Q = "q";
	private String PARA_ORDER = "order";
	private String PARA_SORT = "sort";
	private String PARA_PAGE = "page";
	private String PARA_PER_PAGE = "per_page";
	private String SPACE = " ";
	private String HRL_PLUS = "&";

	@GET
	@Path("/")
	@Produces("application/json")
	public String doSearch(@DefaultValue("") @QueryParam("q") String q,
			@DefaultValue("") @QueryParam("sort") String sort, @DefaultValue("") @QueryParam("order") String order,
			@DefaultValue("") @QueryParam("page") String page,
			@DefaultValue("") @QueryParam("per_page") String per_page) throws Exception {
		String requestParameters = "";
		if (!q.isEmpty()) {
			requestParameters = PARA_Q + "=" + StringUtil.replace(q, SPACE, "+");
		}
		if (!sort.isEmpty()) {
			requestParameters = requestParameters + HRL_PLUS + PARA_SORT + "=" + sort;
		}
		if (!order.isEmpty()) {
			requestParameters = requestParameters + HRL_PLUS + PARA_ORDER + "=" + order;
		}
		if (!sort.isEmpty()) {
			requestParameters = requestParameters + HRL_PLUS + PARA_SORT + "=" + sort;
		}
		if (!page.isEmpty()) {
			requestParameters = requestParameters + HRL_PLUS + PARA_PAGE + "=" + page;
		}
		if (!per_page.isEmpty()) {
			requestParameters = requestParameters + HRL_PLUS + PARA_PER_PAGE + "=" + per_page;
		}
		if (!requestParameters.isEmpty()) {
			requestParameters = "?" + requestParameters;
		}
		return HttpClientUtil.sendGet(requestParameters);

	}

}
