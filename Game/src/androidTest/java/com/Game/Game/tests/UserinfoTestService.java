/**package com.Game.Game.tests;

import com.Game.Game.Userinfo;
import com.tech.services.user.UserInfoService;
import com.tech.AbstractTest;
import com.tech.models.entities.user.UserInfo;
import com.tech.repositories.IUserInfoRepository;
import com.tech.services.interfaces.IUserInfoService;
import java.util.ArrayList;
import javax.transaction.Transactional;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.InjectMocks;
import static org.mockito.Matchers.anyLong;
import org.mockito.Mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.web.WebAppConfiguration;
import static org.mockito.Mockito.verify;
import org.mockito.MockitoAnnotations;

import java.util.Date;
import java.util.List;



@Transactional
@WebAppConfiguration
@ActiveProfiles({"stb","stb"})
public class UserinfoServiceTest extends AbstractTest{
    @Mock
    private IUserinfoRepository repository;
    @InjectMocks
    private UserinfoService mockService;

    @Autowired
    private IUserinfoService service;

    Userinfo userExist = null;
    Userinfo userNotExist = null;
    private Object MockitoAnnotations;

    public UserinfoServiceTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        userNotExist = new Userinfo(3,"user123","12345","k@gmail.com",3);
        userExist = new Userinfo(4,"stb","321","sb@gmail.com",4);

    }

    @After
    public void tearDown() {
        userNotExist = null;
        userExist = null;
    }

    /**
     * Transactional annotation disables modifications of the DB. So testing a modification function was unable with
     * direct access of database. Mocking the service / repository allow us to verify that the modification function is called
     * with the correct arguments. the Query is already tested for being correct so if its called it means the the modification is done
     */

  /**  @Test
    @Sql(scripts = "classpath:populateDB.sql")
    public void testModifyUserinfo() {
        Userinfo mockedChangedUser = new Userinfo(Long.parseLong("3"),"k@gmail.com","12345",Long.parseLong("3"));

        Userinfo userinfoOrigin = service.getUserinfoByUserId(userExist.getUserid());
        when(mockService.getUserinfoByUserId(3)).thenReturn(mockedChangedUser);

        mockService.modifyUserinfo(mockedChangedUser);
        Userinfo tmp = mockService.getUserinfoByUserId(userExist.getUserid());

        verify(repository, times(1)).findByUserid(anyLong());
        verify(repository, times(1)).setUserinfoById(mockedChangedUser.getUsername(),mockedChangedUser.getPassword(),mockedChangedUser.getEmail(),mockedChangedUser.getCharid());

        Assert.assertEquals("Fail Modify User Info,expected same id", userinfoOrigin.getUserid(), tmp.getUserid());


    }

    /**
     * Test of addUserinfo method, of class UserinfoService.
     */
  /**  @Test
    @Sql(scripts = "classpath:populateDB.sql")
    public void testAddUserinfo() {
        Userinfo userinfo = new Userinfo(4,"stb","321","sb@gmail.com",);
        service.addUserinfo(userinfo);
        Assert.assertNotNull("Fail add User",service.getUserinfoByUserId(userinfo.getUserid()));
    }

    /**
     * Test of getUserinfoByUserId method, of class UseinfoService.
     */
  /**  @Test
    @Sql(scripts = "classpath:populateDB.sql")
    public void testGetUserinfoByUserId() {
        Assert.assertEquals("Fail get User By Id",userExist.getUserid(),service.getUserinfoByUserId(userExist.getUserid()).getUserid());
    }



}
