import React, {useState} from 'react';
import {Route, Switch, useRouteMatch} from 'react-router';
import {Layout} from 'antd';
import sideMenuItems from '../../util/sideMenuItems';
import Navbar from '../../component/navbar';
import SideMenu from '../../component/sideMenu';
import CurrentPage from '../../component/currentPage';
import {page} from '../../route/path';

const {Header, Content, Footer, Sider} = Layout;

const CommonLayOut = (props) => {
    const [collapsed, setCollapsed] = useState(false);
    let {path, url} = useRouteMatch();
    const handleCollapse = (collapsed) => {
        setCollapsed(collapsed);
    };
    return (
        <Layout style={{minHeight: '100vh'}}>
            <Header className='bg-gray-800 p-2 h-auto leading-none'>
                <Navbar/>
            </Header>
            <Layout>
                <Sider
                    theme='light'
                    collapsible
                    collapsed={collapsed}
                    onCollapse={handleCollapse}
                >
                    <SideMenu url={url} sideMenuItems={sideMenuItems}/>
                </Sider>
                <Layout className='site-layout'>
                    <Content style={{margin: '0 16px'}}>
                        <CurrentPage/>
                        <section className='bg-white p-10 rounded min-h-full'>
                            <Switch>
                                {page ? (
                                    page.map((item) => (
                                        <Route
                                            key={item.key}
                                            exact={item.exact}
                                            path={`${path}${item.path}`}
                                            component={item.component}
                                        />
                                    ))
                                ) : (
                                    <></>
                                )}
                            </Switch>
                        </section>
                    </Content>
                    <Footer style={{textAlign: 'center'}}>Snow cot admin</Footer>
                </Layout>
            </Layout>
        </Layout>
    );
};

export default CommonLayOut;
