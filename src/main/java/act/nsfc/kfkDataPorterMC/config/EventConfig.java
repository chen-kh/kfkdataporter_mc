package act.nsfc.kfkDataPorterMC.config;

import java.util.HashMap;
import java.util.Map;

/**
 * 告警配置配置
 * @author Fanpingan
 *
 */
public class EventConfig {
	public static final Map<String, Integer> EVENT_TYPE = new HashMap<String, Integer>();
	static {
		EVENT_TYPE.put("00000001",66);//急加速报警
		EVENT_TYPE.put("00000002",67);//急减速报警
		EVENT_TYPE.put("00000003",73);//接头插入报警
		EVENT_TYPE.put("00000004",72);//VIN码上报
		EVENT_TYPE.put("00000005",0);//支持数据流ID列表上报
		EVENT_TYPE.put("00000006",26);//停车后车灯未关报警
		EVENT_TYPE.put("00000007",14);//停车后尾箱未关报警
		EVENT_TYPE.put("00000008",13);//停车后车窗未关报警
		EVENT_TYPE.put("00000009",12);//停车后车门未锁报警
		EVENT_TYPE.put("0000000A",11);//停车后车门未关报警
		EVENT_TYPE.put("0000000B",3);//胎压报警
		EVENT_TYPE.put("0000000C",0);//停车后状态判断
		EVENT_TYPE.put("0000000D",15);//驻车震动报警
		EVENT_TYPE.put("0000000E",2);//水温过高报警-水温
		EVENT_TYPE.put("0000000F",27);//超速报警-速度
		EVENT_TYPE.put("00000010",22);//怠速报警-怠速时间
		EVENT_TYPE.put("00000011",4);//电压异常报警
		EVENT_TYPE.put("00000012",50);//转速异常
		EVENT_TYPE.put("00000013",51);//急加油
		EVENT_TYPE.put("00000014",52);//预热时间过长
		EVENT_TYPE.put("00000015",53);//冷车高速行驶
		EVENT_TYPE.put("00000016",54);//低油量下行驶
		EVENT_TYPE.put("00000017",55);//夜间不开灯行驶
		EVENT_TYPE.put("00000018",56);//手刹未解除行驶
		EVENT_TYPE.put("00000019",57);//空挡滑行
		EVENT_TYPE.put("0000001A",58);//停车不挂P/N档
		EVENT_TYPE.put("0000001B",59);//未系安全带
		EVENT_TYPE.put("0000001C",60);//车门未关行驶
		EVENT_TYPE.put("0000001D",61);//车门未锁行驶
		EVENT_TYPE.put("0000001E",62);//尾箱未关行驶
		EVENT_TYPE.put("0000001F",5);//油量不足
		EVENT_TYPE.put("00000020",0);//车辆启动 16
		EVENT_TYPE.put("00000022",74);//接头失联
		EVENT_TYPE.put("00000025",25);//疲劳驾驶

	}

}
