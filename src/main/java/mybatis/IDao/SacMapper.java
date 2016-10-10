package mybatis.IDao;

import mybatis.domain.Sac;

public interface SacMapper {
    int insert(Sac record);

    int insertSelective(Sac record);
}