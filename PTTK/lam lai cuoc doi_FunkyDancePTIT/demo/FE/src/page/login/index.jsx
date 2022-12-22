import {useEffect, useState} from 'react';
import {Form, Input, Button, Alert} from 'antd';
import {useDispatch, useSelector} from 'react-redux';
// import {
//   handleLogin,
//   handleRemoveError,
// } from '../../state/actions/adminAction';

const Login = (props) => {
    const admin = useSelector((state) => state.admin);
    const dispatch = useDispatch();
    const [loading, setLoading] = useState(false);

    const onFinish = (values) => {
        if (loading) return;
        // dispatch(handleLogin(values));
    };

    return (
        <div className='w-1/3 p-10 bg-white rounded-xl shadow-lg'>
            <h1 className='text-center text-7xl text-green-500 mb-10 font-Pattaya'>
                Snow Cot Admin
            </h1>
            {admin.hasOwnProperty('error') ? (
                <Alert
                    className='mb-3'
                    message={admin.error}
                    showIcon
                    type='error'
                    closable
                    // onClose={() => dispatch(handleRemoveError())}
                />
            ) : (
                <></>
            )}

            <Form
                name='basic'
                initialValues={{
                    remember: true,
                }}
                onFinish={onFinish}
            >
                <Form.Item
                    label='Username'
                    name='username'
                    rules={[
                        {
                            required: true,
                            message: 'Please type your username!',
                        },
                    ]}
                >
                    <Input/>
                </Form.Item>

                <Form.Item
                    label='Password'
                    name='password'
                    rules={[
                        {
                            required: true,
                            message: 'Please type your password!',
                        },
                    ]}
                >
                    <Input.Password/>
                </Form.Item>

                <Form.Item className='text-center'>
                    <Button
                        className={`bg-blue-500 hover:bg-red-500 ${
                            loading ? 'cursor-not-allowed' : ''
                        }`}
                        type='primary'
                        htmlType='submit'
                    >
                        Login
                    </Button>
                </Form.Item>
            </Form>
        </div>
    );
};

export default Login;
