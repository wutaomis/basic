package mybatis.IDao;

import mybatis.domain.Tstrfv2;

public interface Tstrfv2Mapper {
    int deleteByPrimaryKey(String transcode);

    int insert(Tstrfv2 record);

    int insertSelective(Tstrfv2 record);

    Tstrfv2 selectByPrimaryKey(String transcode);

    int updateByPrimaryKeySelective(Tstrfv2 record);

    int updateByPrimaryKey(Tstrfv2 record);
}