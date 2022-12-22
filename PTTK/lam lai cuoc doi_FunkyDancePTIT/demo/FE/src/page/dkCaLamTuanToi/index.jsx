import {Route, Switch, useRouteMatch} from 'react-router';
import {DKCaLam} from '../../route/path';

const DKCaLamTuanToi = (props) => {
    const {path, url} = useRouteMatch();

    return (
        <div>
            <Switch>
                {DKCaLam ? (
                    DKCaLam.map((item) => {
                        const Component = item.component;
                        return (
                            <Route
                                key={item.key}
                                exact={item.exact}
                                path={`${path}${item.path}`}
                            >
                                <Component url={url}/>
                            </Route>
                        );
                    })
                ) : (
                    <></>
                )}
            </Switch>
        </div>
    );
};

export default DKCaLamTuanToi;
