package com;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.sys.entity.Label;
import com.sys.mapper.LabelMapper;
import com.sys.mapper.UserinfoMapper;
import com.sys.service.ILabelService;

@SpringBootTest
class DeleteTest {

	@Autowired
	UserinfoMapper UserinfoMapper;
	
	@Autowired
	private  ILabelService ILabelService;
	
	@Autowired
	LabelMapper LabelMapper;
	
		@Test
		void deleteBatchIds() {
			int rows = UserinfoMapper.deleteBatchIds(Arrays.asList(16926,16927,16928));
			System.out.println("删除行数:"+rows);
		}
		
		
		@Test
		void ARlabel() {
			Label label = new Label();
				label.setId(11); //直播审核
			boolean result = label.deleteById();
			System.out.println(result);
		}
		
		@Test
		 void getOne() {
//			Label one = ILabelService.
//					getOne(Wrappers.<Label>lambdaQuery().like(Label::getLabelname,"武斌"));//报错
			Label one = ILabelService.
				getOne(Wrappers.<Label>lambdaQuery().like(Label::getLabelname,"武斌").orderByDesc(Label::getId).orderByDesc(Label::getCreatime),false);//不报错
			System.out.println(one);
		}
		
		@Test
		 void batchcaozuo() {
			Label label = new Label();
				
				label.setLabelname("谭竹青买房");//insert
			
			Label label2 = new Label();//update
				label2.setId(11);
				label2.setCreatime(LocalDateTime.now());
				label2.setLabelname("谭竹青没房");
			
			List<Label> asList = Arrays.asList(label,label2);
			boolean saveBatch = ILabelService.saveOrUpdateBatch(asList);
			System.out.println(saveBatch);
		}
		
		@Test
	    void chain_1() {
//			List<Label> list = ILabelService.lambdaQuery().like(Label::getLabelname,"武斌").list();
			List<Label> list = ILabelService.lambdaQuery().like(Label::getLabelname,"武斌").list();
			list.forEach(System.out::println);
		}
		
		@Test
	    void chain() {
			boolean remove = ILabelService.lambdaUpdate().like(Label::getLabelname,"武斌").remove();
			System.out.println(remove);
		}
		
		/***
		 * 逻辑删除 然后调用getone看到效果 
		 * 注意:对于自定义的sql mapper不起作用
		 */
		@Test
		void logicdelete() {
			int rows = LabelMapper.deleteById(34);
			System.out.println(rows);
		}
		
		
}
