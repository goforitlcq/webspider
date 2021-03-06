package com.gofoit.webspider.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.gofoit.webspider.factory.SSCRepoFactory;
import com.gofoit.webspider.factory.impl.TJSSCRepoFactory;
import com.gofoit.webspider.model.list.impl.CQSSCRepoOriginalList;
import com.gofoit.webspider.model.list.impl.GD11TO5RepoOriginalList;
import com.gofoit.webspider.model.list.impl.TJSSCRepoOriginalList;
import com.gofoit.webspider.pipeline.SSCPageModelPipeline;

import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.model.OOSpider;

public class SSCScheduleTask {
	@Autowired
	@Qualifier("CQSSCRepoFactory")
	private SSCRepoFactory cqSSCRepoFactory;
	@Autowired
	@Qualifier("TJSSCRepoFactory")
	private SSCRepoFactory tjSSCRepoFactory;
	
	/**
	 * 抓取重庆时时彩
	 */
	public void grabCQSSC(){
		SSCPageModelPipeline sscPageModelPipeline = new SSCPageModelPipeline();
		sscPageModelPipeline.setSscRepoFactory(new TJSSCRepoFactory());
		 OOSpider.create(Site.me(), sscPageModelPipeline, CQSSCRepoOriginalList.class)
	        .addUrl("http://shishicai.cjcp.com.cn/chongqing/kaijiang/")
	        .thread(1)
	        .run();
	}
	
	/**
	 * 抓取天津时时彩
	 */
	public void grabTJSSC(){
		SSCPageModelPipeline sscPageModelPipeline = new SSCPageModelPipeline();
		sscPageModelPipeline.setSscRepoFactory(new TJSSCRepoFactory());
		 OOSpider.create(Site.me(), sscPageModelPipeline, TJSSCRepoOriginalList.class)
	        .addUrl("http://shishicai.cjcp.com.cn/tianjin/kaijiang/")
	        .thread(1)
	        .run();
	}
	
	/**
	 * 抓取广东11选5
	 */
	public void grabGD11TO5(){
		SSCPageModelPipeline sscPageModelPipeline = new SSCPageModelPipeline();
		sscPageModelPipeline.setSscRepoFactory(new TJSSCRepoFactory());
		 OOSpider.create(Site.me(), sscPageModelPipeline, GD11TO5RepoOriginalList.class)
	        .addUrl("http://11xuan5.cjcp.com.cn/guangdong/kaijiang/")
	        .thread(1)
	        .run();
	}
	/**
	 * 每5分钟执行的任务
	 */
	public void per5MinuteTask(){
		grabCQSSC();
		grabTJSSC();
		grabGD11TO5();
	}
}
