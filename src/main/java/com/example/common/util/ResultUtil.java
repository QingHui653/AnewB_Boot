package com.example.common.util;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * 返回参数工具类
 * successful:返回是否成功
 * Resultmessage:输出信息
 * ResultBean:返回bean
 * ResultBeanList：返回bean
 * ResultMap:返回多种bean
 * @author woshizbh
 */
public class ResultUtil implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private boolean successful;		//返回结果
	
	private String Resultmessage;  //返回结果信息
	
	private Object ResultBean;  //返回单个bean
	
	private List<Object> ResultBeanList; //返回ListBean
	
	private Map<String,Object> ResultMap; //返回Map

	public ResultUtil() {
		super();
	}

	public ResultUtil(boolean successful, String resultmessage) {
		super();
		this.successful = successful;
		Resultmessage = resultmessage;
	}

	public ResultUtil(boolean successful, String resultmessage, Object resultBean) {
		super();
		this.successful = successful;
		Resultmessage = resultmessage;
		ResultBean = resultBean;
	}

	public boolean isSuccessful() {
		return successful;
	}

	public Object getResultBean() {
		return ResultBean;
	}

	public void setResultBean(Object resultBean) {
		ResultBean = resultBean;
	}

	public List<Object> getResultBeanList() {
		return ResultBeanList;
	}

	public void setResultBeanList(List<Object> resultBeanList) {
		ResultBeanList = resultBeanList;
	}

	public Map<String, Object> getResultMap() {
		return ResultMap;
	}

	public void setResultMap(Map<String, Object> resultMap) {
		ResultMap = resultMap;
	}

	public String getResultmessage() {
		return Resultmessage;
	}

	public void setResultmessage(String resultmessage) {
		Resultmessage = resultmessage;
	}

	public void setSuccessful(boolean successful) {
		this.successful = successful;
	}

	@Override
	public String toString() {
		String retValue = "";
		retValue = "Result ( " + super.toString() + "    " + "successful = " + successful + "    " + "resultList = " + ResultBeanList + "    " + "resultMap = " + ResultMap + "    " + "result = " + ResultBean + "    " + "message = " + Resultmessage + "    " + " )";
		return retValue;
	}
	
	
}
