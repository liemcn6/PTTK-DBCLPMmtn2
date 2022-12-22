import { Link, useLocation } from 'react-router-dom';
import SearchBar from '../../../component/searchBar';
import axios from 'axios';
import axios_base from '../../../request/baseRequest';
import 'antd/dist/antd.css';
import { Table } from 'antd';
import { useState } from 'react';
import { useEffect } from 'react';

const SearchAndChoose = (props) => {
  const { url } = props;
  const [data, setData] = useState([]);
  const [error, setError] = useState({});

  const handleSearch = async (keyword) => {
    try {
      const res = await axios_base().get('nvptSearch', {
        params: { keyword },
      });
      setData(res.data);
    } catch (error) {
      setError(error.response.data);
    }
  };
  const location = (data) => ({
    pathname: `${url}/staffDetail/${data.id}`,
    state: { data, url },
  });
  const columns = [
    {
      title: 'Tên Nhân Viên',
      dataIndex: 'ten',
      key: 'ten',
      render: (text, record) => <Link to={location(record)}>{text}</Link>,
    },
    {
      title: 'Ngày sinh',
      dataIndex: 'ngaySinh',
      key: 'ngaySinh',
      render: (text, record) => <Link to={location(record)}>{text}</Link>,
    },
    {
      title: 'Ngày vào làm',
      dataIndex: 'ngayVaoLam',
      key: 'ngayVaoLam',
      render: (text, record) => <Link to={location(record)}>{text}</Link>,
    },
    {
      title: 'Chức vụ',
      dataIndex: 'chucVu',
      key: 'chucVu',
      render: (text, record) => <Link to={location(record)}>{text}</Link>,
    },
  ];

  return (
    <div>
      <div className='flex justify-center mx-2 mb-5'>
        <SearchBar
          className='w-1/2'
          placeholder='Type to search'
          onSubmit={handleSearch}
        />
      </div>
      <Table
        columns={columns}
        rowKey={(rowData) => rowData.id}
        dataSource={data}
      />
    </div>
  );
};

export default SearchAndChoose;
