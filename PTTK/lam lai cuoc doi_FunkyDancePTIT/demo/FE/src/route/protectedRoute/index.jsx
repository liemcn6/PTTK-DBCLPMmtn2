import React from 'react';
import {Redirect, Route} from 'react-router';
import useAuth from '../../hooks/useAuth';

const ProtectedRoute = ({component: Component, ...rest}) => {
    const isAuth = useAuth();
    console.log(isAuth);
    return (
        <Route
            {...rest}
            render={(props) =>
                isAuth ? <Redirect to='/dashboard'/> : <Component {...props} />
            }
        />
    );
};

export default ProtectedRoute;
