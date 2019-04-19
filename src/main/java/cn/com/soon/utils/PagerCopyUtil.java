package cn.com.soon.utils;

import cn.com.soon.dto.OrderDTO;
import cn.com.soon.model.OrderMaster;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;

/**
 * @author song.qh
 * @date 2019/3/17
 */
public class PagerCopyUtil {

    public static void setPageInfo(PageInfo<OrderMaster> pageOmInfo, PageInfo<OrderDTO> pageOdInfo) {
        BeanUtils.copyProperties(pageOmInfo, pageOdInfo, "list");
    }
}
