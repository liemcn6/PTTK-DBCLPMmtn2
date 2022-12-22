import React from 'react';
import {Redirect, Route} from 'react-router';
import useAuth from '../../hooks/useAuth';

const PrivateRoute = ({component: Component, ...rest}) => {
    const isAuth = useAuth();
    return (
        <Route
            {...rest}
            render={(props) =>
                isAuth ? <Component {...props} /> : <Redirect to='/login'/>
            }
        />
    );
};

export default PrivateRoute;
