import {useDispatch, useSelector} from 'react-redux';
import {Tooltip} from 'antd';
import {FontAwesomeIcon} from '@fortawesome/react-fontawesome';
import {faPowerOff} from '@fortawesome/free-solid-svg-icons';
import ImageCtn from '../../component/imageCtn';

import {handleLogout} from '../../state/actions/adminActions';

const Navbar = (props) => {
    const dispatch = useDispatch();
    const admin = useSelector((state) => state.admin);
    const handleLogOut = () => {
        dispatch(handleLogout());
    };
    return (
        <nav className='flex items-center'>
            <h1 className='text-gray-50 px-10 text-4xl font-Pattaya'>Admin</h1>
            <ul className='flex ml-auto text-white items-center'>
                <li>
                    <div className='flex p-1 px-2 bg-white hover:bg-gray-100 items-center rounded-lg'>
                        <p className='text-xl text-gray-500 cursor-default'>
                            {admin?.hasOwnProperty('username') ? admin.username : 'Lekhanh'}
                        </p>
                        <ImageCtn
                            className={'square rounded-full w-7 ml-2 self-start'}
                            notLink={true}
                            src={
                                admin?.hasOwnProperty('avatar')
                                    ? admin.avatar
                                    : 'https://i.ytimg.com/vi/1Ne1hqOXKKI/maxresdefault.jpg'
                            }
                            alt={'this is avatar'}
                        />
                    </div>
                </li>
                <li className='mx-4'>
                    <Tooltip title='Log out' placement='left'>
                        <button
                            className='inline-block px-1.5 rounded-full
        align-middle text-lg bg-red-500 hover:bg-red-700 
        outline-none focus:outline-none'
                            onClick={handleLogOut}
                        >
                            <FontAwesomeIcon icon={faPowerOff}/>
                        </button>
                    </Tooltip>
                </li>
            </ul>
        </nav>
    );
};

export default Navbar;
