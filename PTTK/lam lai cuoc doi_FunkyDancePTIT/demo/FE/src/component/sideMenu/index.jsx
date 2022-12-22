import {Link} from 'react-router-dom';
import {Menu, Tooltip} from 'antd';
import SubMenu from 'antd/lib/menu/SubMenu';
import useCurrentRoute from '../../hooks/useCurrentRoute';

const SideMenu = (props) => {
    const {url, sideMenuItems} = props;
    const currentRoute = useCurrentRoute();
    const handleSelected = () => {
        for (let item of sideMenuItems) {
            if (item.sub) {
                for (let subItem of item.items) {
                    const subItemPath = subItem.linkTo.split('/');
                    if (currentRoute[1] === subItemPath[2]) {
                        return [item.key, subItem.key];
                    }
                }
            }
            if (item.linkTo) {
                const itemPath = item.linkTo.split('/');
                if (currentRoute[0] === itemPath[1]) return [item.key];
            }
            if (item.linkTo === '')
                if (currentRoute[0] === item.linkTo) return [item.key];
        }
    };
    return (
        <Menu
            defaultSelectedKeys={handleSelected()}
            selectedKeys={handleSelected()}
            mode='inline'
        >
            {sideMenuItems ? (
                sideMenuItems.map((item) =>
                    !item.sub ? (
                        <Menu.Item
                            style={{lineHeight: '18px'}}
                            key={item.key}
                            icon={item.icon}
                        >
                            <Link
                                className='whitespace-normal flex'
                                to={`${url}${item.linkTo}`}
                            >
                                {item.title}
                            </Link>
                        </Menu.Item>
                    ) : (
                        <SubMenu key={item.key} icon={item.icon} title={item.title}>
                            {item.items.map((subItem) => (
                                <Menu.Item key={subItem.key} style={{lineHeight: '18px'}}>
                                    <Link
                                        className='whitespace-normal flex'
                                        to={`${url}${subItem.linkTo}`}
                                    >
                                        {subItem.title}
                                    </Link>
                                </Menu.Item>
                            ))}
                        </SubMenu>
                    )
                )
            ) : (
                <></>
            )}
        </Menu>
    );
};

export default SideMenu;
