import React from 'react';
import {Router, Switch, Redirect, Route} from 'react-router';
import history from './history';
import PrivateRoute from './route/privateRoute';
import ProtectedRoute from './route/protectedRoute';
import CommonLayout from './layout/commonLayout';
import loginLayout from './layout/loginLayout';

function App() {
    return (
        <div className='App'>
            <Router history={history}>
                <Switch>
                    <Route exact path='/'>
                        <Redirect to='/login'/>
                    </Route>
                    <PrivateRoute path='/dashboard' component={CommonLayout}/>
                    <ProtectedRoute path='/login' component={loginLayout}/>
                </Switch>
            </Router>
        </div>
    );
}

export default App;
