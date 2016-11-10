package cn.opencil.oa.core.web.notice;

import cn.opencil.oa.core.domain.Notice;
import cn.opencil.oa.core.web.notice.service.NoticeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.Date;

/**
 * Created with Sdut-jsj-OA.
 * Package: cn.opencil.oa.core.web.notice
 * User: 张树伟
 * Date: 16-11-10
 * Time: 上午10:05
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = "classpath:cn/opencil/oa/core/spring/applicationContext-*.xml")
public class NoticeTest {

    @Autowired
    NoticeService noticeService;

    @Test
    public void addTest() {
        Notice notice = new Notice();
        notice.setUuid("wwww");
        Date date = new Date(1);
        notice.setBeginDate(date);
        notice.setContent("<dd class=\"desc\">\n" +
                "<div class=\"lemma-summary\" label-module=\"lemmaSummary\">\n" +
                "<div class=\"para\" label-module=\"para\">文章，1984年6月26日出生于<a target=\"_blank\" href=\"/item/%E9%99%95%E8%A5%BF%E7%9C%81\">陕西省</a><a target=\"_blank\" href=\"/view/55207.htm\">西安市</a>，中国内地<a target=\"_blank\" href=\"/view/954419.htm\">男演员</a>、导演。2006年毕业于<a target=\"_blank\" href=\"/view/15261.htm\">中央戏剧学院</a>表演系。</div><div class=\"para\" label-module=\"para\">2004年参演电视剧《<a target=\"_blank\" href=\"/view/200920.htm\">与青春有关的日子</a>》，开始在影视圈<a target=\"_blank\" href=\"/view/119830.htm\">崭露头角</a><sup>[1]</sup><a class=\"sup-anchor\" name=\"ref_[1]_5192786\">&nbsp;</a>\n" +
                "。2005年拍摄古装剧《<a target=\"_blank\" href=\"/subview/18552/5478491.htm\" data-lemmaid=\"9369877\">锦衣卫</a>》。2007年主演<a target=\"_blank\" href=\"/view/80804.htm\">赵宝刚</a>导演的<a target=\"_blank\" href=\"/view/13813525.htm\">青春剧</a>《<a target=\"_blank\" href=\"/subview/54021/5450254.htm\" data-lemmaid=\"9000941\">奋斗</a>》；<sup>[2]</sup><a class=\"sup-anchor\" name=\"ref_[2]_5192786\">&nbsp;</a>\n" +
                "同年，主演首部电影《<a target=\"_blank\" href=\"/view/10030.htm\">走着瞧</a>》。2008年主演<a target=\"_blank\" href=\"/view/2163632.htm\">滕华涛</a>执导的电视剧《<a target=\"_blank\" href=\"/view/647503.htm\">蜗居</a>》，饰演80后城市青年<a target=\"_blank\" href=\"/subview/292686/5120774.htm\" data-lemmaid=\"3565242\">小贝</a>。<sup>[1]</sup><a class=\"sup-anchor\" name=\"ref_[1]_5192786\">&nbsp;</a>\n" +
                "2009年，在电影《<a target=\"_blank\" href=\"/view/2761272.htm\">海洋天堂</a>》中扮演<a target=\"_blank\" href=\"/subview/334/4982218.htm\" data-lemmaid=\"311\">自闭症</a>患者王大福；同年参演<a target=\"_blank\" href=\"/subview/276573/5143919.htm\" data-lemmaid=\"5141\">抗战</a>题材的电视剧《<a target=\"_blank\" href=\"/view/4042.htm\">雪豹</a>》<sup>[4]</sup><a class=\"sup-anchor\" name=\"ref_[4]_5192786\">&nbsp;</a>\n" +
                "。2011年，主演的电视剧《<a target=\"_blank\" href=\"/view/3865903.htm\">裸婚时代</a>》在各大<a target=\"_blank\" href=\"/view/55362.htm\">卫视</a>播出；<sup>[5]</sup><a class=\"sup-anchor\" name=\"ref_[5]_5192786\">&nbsp;</a>\n" +
                "2011年-2012年连续2年获得<a target=\"_blank\" href=\"/view/557870.htm\">北京大学生电影节</a><sup>[6-7]</sup><a class=\"sup-anchor\" name=\"ref_[6-7]_5192786\">&nbsp;</a>\n" +
                "最受大学生欢迎男演员奖。2012年，凭借电影《<a target=\"_blank\" href=\"/view/3158523.htm\">失恋33天</a>》获得第31届<a target=\"_blank\" href=\"/view/30483.htm\">大众电影百花奖</a>最佳男主角奖；<sup>[8]</sup><a class=\"sup-anchor\" name=\"ref_[8]_5192786\">&nbsp;</a>\n" +
                "同年成立自己经营的北京君竹影视文化有限公司，并导演第一部影视作品《<a target=\"_blank\" href=\"/view/9198850.htm\">小爸爸</a>》。2013年2月，主演的电影《<a target=\"_blank\" href=\"/subview/9632495/10142686.htm\" data-lemmaid=\"67853\">西游·降魔篇</a>》在全国上映。<sup>[9]</sup><a class=\"sup-anchor\" name=\"ref_[9]_5192786\">&nbsp;</a>\n" +
                "</div><div class=\"para\" label-module=\"para\">2014年3月28日，主演的中韩<a target=\"_blank\" href=\"/view/191046.htm\">合资</a><a target=\"_blank\" href=\"/subview/419298/5110427.htm\" data-lemmaid=\"3185\">文艺</a><a target=\"_blank\" href=\"/view/928534.htm\">爱情片</a>《<a target=\"_blank\" href=\"/view/12324440.htm\">我在路上最爱你</a>》在全国上映。2014年12月18日，在<a target=\"_blank\" href=\"/view/64453.htm\">姜文</a>执导的动作<a target=\"_blank\" href=\"/view/60040.htm\">喜剧片</a>《<a target=\"_blank\" href=\"/subview/1365880/9972229.htm\" data-lemmaid=\"66613\">一步之遥</a>》中扮演武七一角。<sup>[10]</sup><a class=\"sup-anchor\" name=\"ref_[10]_5192786\">&nbsp;</a>\n" +
                "2016年，主演电视剧《<a target=\"_blank\" href=\"/subview/1746973/15773774.htm\" data-lemmaid=\"15845151\">少帅</a>》，饰演<a target=\"_blank\" href=\"/subview/4095/4998270.htm\" data-lemmaid=\"385\">张学良</a><sup>[11]</sup><a class=\"sup-anchor\" name=\"ref_[11]_5192786\">&nbsp;</a>\n" +
                "；主演电视剧《<a target=\"_blank\" href=\"/subview/488000/18856411.htm\" data-lemmaid=\"18605107\">剃刀边缘</a>》<sup>[12]</sup><a class=\"sup-anchor\" name=\"ref_[12]_5192786\">&nbsp;</a>\n" +
                "。7月15日导演的电影《<a target=\"_blank\" href=\"/item/%E9%99%86%E5%9E%9A%E7%9F%A5%E9%A9%AC%E4%BF%90/18152183\" data-lemmaid=\"18152183\">陆垚知马俐</a>》上映。<sup>[13]</sup><a class=\"sup-anchor\" name=\"ref_[13]_5192786\">&nbsp;</a>\n" +
                "</div><div class=\"para\" label-module=\"para\">演艺事业外，文章也参与<a target=\"_blank\" href=\"/view/1450.htm\">公益</a>慈善事业，2010年成立<a target=\"_blank\" href=\"/view/4037393.htm\">大福自闭症关爱基金</a>。</div>\n" +
                "</div>\n" +
                "</dd>");
        notice.setTitle("呵呵呵sss呵呵！");
        notice.setUser("章撒大厦");
        noticeService.addEntry(notice);
    }
}
