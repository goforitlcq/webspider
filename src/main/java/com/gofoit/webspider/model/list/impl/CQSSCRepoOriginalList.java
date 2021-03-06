package com.gofoit.webspider.model.list.impl;

import java.util.List;

import com.gofoit.webspider.factory.impl.CQSSCRepoFactory;
import com.gofoit.webspider.factory.impl.TJSSCRepoFactory;
import com.gofoit.webspider.model.list.SSCRepoOriginalList;
import com.gofoit.webspider.model.type.SSCTypeEnum;
import com.gofoit.webspider.pipeline.SSCPageModelPipeline;

import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.model.OOSpider;
import us.codecraft.webmagic.model.annotation.ExtractBy;
import us.codecraft.webmagic.model.annotation.TargetUrl;

/**
 * 重庆六合彩
 * 
 * @author luchangqing
 *
 */
@TargetUrl("http://shishicai.cjcp.com.cn/chongqing/kaijiang/")
public class CQSSCRepoOriginalList implements SSCRepoOriginalList{
	@ExtractBy("//table[@class='kjjg_table']/tbody/tr/td/regex('\\d{11}')")
	private List<String> issueList;
	@ExtractBy("//table[@class='kjjg_table']/tbody/tr/td/div/div/regex('\\d{1}')")
	private List<String> numList;
	
	private SSCTypeEnum type = SSCTypeEnum.CQSSC;
	
	public SSCTypeEnum getType() {
		return type;
	}

	public void setType(SSCTypeEnum type) {
		this.type = type;
	}

	public List<String> getIssueList() {
		return issueList;
	}

	public void setIssueList(List<String> issueList) {
		this.issueList = issueList;
	}

	public List<String> getNumList() {
		return numList;
	}

	public void setNumList(List<String> numList) {
		this.numList = numList;
	}

	public static void main(String[] args) {
		SSCPageModelPipeline sscPageModelPipeline = new SSCPageModelPipeline();
		sscPageModelPipeline.setSscRepoFactory(new TJSSCRepoFactory());
		 OOSpider.create(Site.me(), sscPageModelPipeline, CQSSCRepoOriginalList.class)
	        .addUrl("http://shishicai.cjcp.com.cn/chongqing/kaijiang/")
	        .thread(1)
	        .run();
    }
}
