import sideMenuItems from '../../util/sideMenuItems';
import useCurrentRoute from '../../hooks/useCurrentRoute';
import {Breadcrumb} from 'antd';

const CurrentPage = (props) => {
    const currentRoute = useCurrentRoute();
    const handlePath = (pathName) => {
        for (let item of sideMenuItems) {
            if (item.sub) {
                for (let subItem of item.items) {
                    const subItemPath = subItem.linkTo.split('/');
                    if (pathName === subItemPath[2]) {
                        return subItem.title;
                    }
                }
            }
            if (item.privSub) {
                for (let privSubItem of item.privSub) {
                    if (pathName === privSubItem.linkTo) return privSubItem.title;
                }
            }
            if (item.linkTo) {
                const itemPath = item.linkTo.split('/');
                if (pathName === itemPath[1]) return item.title;
            }
            if (item.linkTo === '') if (pathName === item.linkTo) return item.title;
        }
        if (isNaN(parseInt(pathName))) return pathName;
        return `Page ${pathName}`;
    };
    return (
        <Breadcrumb style={{margin: '16px 0'}}>
            {currentRoute.map((item) => (
                <Breadcrumb.Item key={item}>{handlePath(item)}</Breadcrumb.Item>
            ))}
        </Breadcrumb>
    );
};

export default CurrentPage;
