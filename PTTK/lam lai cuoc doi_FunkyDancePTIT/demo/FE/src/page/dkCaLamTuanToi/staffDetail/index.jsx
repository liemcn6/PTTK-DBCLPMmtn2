import { Table, Tooltip } from 'antd';
import axios from 'axios';
import { useState } from 'react';
import { useEffect } from 'react';
import { useLocation } from 'react-router';
import { Link } from 'react-router-dom';
import axios_base from '../../../request/baseRequest';

const shiftCheckInit = [
  [0, 0, 1],
  [0, 0, 1],
  [0, 0, 1],
  [0, 0, 1],
  [0, 0, 1],
  [0, 0, 1],
  [0, 0, 1],
];

const StaffDetail = (props) => {
  const location = useLocation();
  const [nvpt, setNvpt] = useState({});
  const [shiftSchedule, setShiftSchedule] = useState({});
  const [shiftCheck, setShiftCheck] = useState(shiftCheckInit);
  const [dayWorks, setDayWorks] = useState([]);
  const [shifts, setShifts] = useState([]);

  // get data
  const getListNgayLV = async () => {
    try {
      const res = await axios.get('/json-file/ngayLV.json');
      setDayWorks(res.data.ngayLV);
    } catch (error) {
      console.log(error.response);
    }
  };
  const getListCaLV = async () => {
    try {
      const res = await axios_base().get('/getAllCaLV');
      setShifts(res.data);
    } catch (error) {
      console.log(error.response);
    }
  };
  const getShiftSchedule = async (id) => {
    try {
      console.log(id);
      const nvpt = await axios_base().get('getLichDKByNVPTId', {
        params: { nvptId: id },
      });
      setNvpt(nvpt.data.nvpt);

      const res = await axios.get('/json-file/nvptLichDK.json');

      const dayOnSchedule = res.data.lichDK.ngayLVTrenLich;
      const newShiftCheck = [...shiftCheck];
      dayOnSchedule.forEach((day, dayIndex) => {
        if (day.caLV !== '') {
          const shiftIndex = shifts.findIndex((shift) => {
            return shift.id == day.caLV.id;
          });
          newShiftCheck[dayIndex] = [0, 0, 0];
          newShiftCheck[dayIndex][shiftIndex] = 1;
        }
      });
      setShiftCheck(newShiftCheck);
      setShiftSchedule(dayOnSchedule);
    } catch (error) {
      console.log(error.response);
    }
  };

  // ulti
  const back = {
    pathname: `${location?.state?.url}`,
  };

  // event
  const handleChangeShift = (shift, rowIndex, cellIndex) => {
    const newShiftCheck = JSON.parse(JSON.stringify(shiftCheck));
    const newShiftSchedule = JSON.parse(JSON.stringify(shiftSchedule));
    if (shift) {
      if (shift.id !== shiftSchedule[rowIndex].caLV?.id) {
        newShiftSchedule[rowIndex].caLV = shift;
        newShiftCheck[rowIndex] = [0, 0, 0];
        newShiftCheck[rowIndex][cellIndex] = 1;
        setShiftSchedule(newShiftSchedule);
        setShiftCheck(newShiftCheck);
      }
      return;
    }
    newShiftSchedule[rowIndex].caLV = shift;
    newShiftCheck[rowIndex] = [0, 0, 0];
    newShiftCheck[rowIndex][cellIndex] = 1;
    setShiftSchedule(newShiftSchedule);
    setShiftCheck(newShiftCheck);
    return;
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    console.log(shiftSchedule);
  };

  useEffect(() => {
    getListNgayLV();
    getListCaLV();
  }, []);

  useEffect(() => {
    const { id } = location?.state?.data;
    console.log(id);
    // getNVPTDetail(id);
    if (shifts.length && dayWorks.length) {
      getShiftSchedule(id);
    }
  }, [location, shifts, dayWorks]);

  return (
    <div classname='staff-detail'>
      <h1 className='mb-5 text-3xl text-center font-bold'>
        Đăng ký lịch làm việc tuần tới cho nhân viên
      </h1>
      <div className={`detail w-5/6 mx-auto`}>
        <h2 className='mb-2 text-xl underline'>Thông tin nhân viên:</h2>
        <div className={`content w-3/5 ml-40 mb-5`}>
          <p className='flex items-center'>
            <span className='flex-1 text-lg text-right pr-16'>
              Tên nhân viên:
            </span>
            <span className='flex-1 ml-2 italic text-gray-400'>{nvpt.ten}</span>
          </p>
          <p className='flex items-center'>
            <span className='flex-1 text-lg text-right pr-16'>
              Phòng ban/ Chức vụ:
            </span>
            <span className='flex-1 ml-2 italic text-gray-400'>{`${nvpt.phongBan}/ ${nvpt.chucVu}`}</span>
          </p>
          <p className='flex items-center'>
            <span className='flex-1 text-lg text-right pr-16'>Ngày sinh: </span>
            <span className='flex-1 ml-2 italic text-gray-400'>
              {nvpt.ngaySinh}
            </span>
          </p>
          <p className='flex items-center'>
            <span className='flex-1 text-lg text-right pr-16'>Địa chỉ: </span>
            <span className='flex-1 ml-2 italic text-gray-400'>
              {nvpt.diaChi}
            </span>
          </p>
          <p className='flex items-center'>
            <span className='flex-1 text-lg text-right pr-16'>
              Ngày vào làm:
            </span>
            <span className='flex-1 ml-2 italic text-gray-400'>
              {nvpt.ngayVaoLam}
            </span>
          </p>
          <p className='flex items-center'>
            <span className='flex-1 text-lg text-right pr-16'>CMT: </span>
            <span className='flex-1 ml-2 italic text-gray-400'>{nvpt.cmt}</span>
          </p>
          <p className='flex items-center'>
            <span className='flex-1 text-lg text-right pr-16'>Email: </span>
            <span className='flex-1 ml-2 italic text-gray-400'>
              {nvpt.email}
            </span>
          </p>
          <p className='flex items-center'>
            <span className='flex-1 text-lg text-right pr-16'>SĐT: </span>
            <span className='flex-1 ml-2 italic text-gray-400'>{nvpt.sdt}</span>
          </p>
        </div>
      </div>
      <div className={`schedule w-5/6 mx-auto`}>
        <h2 className='mb-5 text-xl underline'>Đăng ký lịch:</h2>
        <form onSubmit={handleSubmit}>
          <div className={`schedule-table mb-5`}>
            <table className='w-4/5 mx-auto'>
              <thead>
                <tr>
                  <th className='bg-gray-200 border border-gray-500 text-lg'>
                    Thứ
                  </th>
                  {shifts.length ? (
                    shifts.map((shift) => (
                      <th
                        key={shift.id}
                        className='bg-gray-200 border border-gray-500 capitalize'
                      >
                        <Tooltip title={shift.moTa} placement='right'>
                          <span>{`${shift.ten}`}</span>
                        </Tooltip>
                      </th>
                    ))
                  ) : (
                    <></>
                  )}
                  <th className='bg-gray-200 border border-gray-500'>Nghỉ</th>
                </tr>
              </thead>
              <tbody>
                {dayWorks.length ? (
                  dayWorks.map((dayWork, rowIndex) => (
                    <tr key={`${dayWork.id}`}>
                      <td className='border border-gray-500 text-center'>
                        <Tooltip title={dayWork.moTa} placement='right'>
                          <span>{`${dayWork.ten}`}</span>
                        </Tooltip>
                      </td>
                      {shifts.length ? (
                        shifts.map((shift, cellIndex) => (
                          <td key={shift.id} className='border border-gray-500'>
                            <Tooltip title={shift.moTa} placement='right'>
                              <label className='flex w-3/5 mx-auto items-center justify-center cursor-pointer'>
                                <input
                                  type='radio'
                                  checked={shiftCheck[rowIndex][cellIndex]}
                                  onChange={() =>
                                    handleChangeShift(
                                      shift,
                                      rowIndex,
                                      cellIndex
                                    )
                                  }
                                />
                                <span className='ml-2'>{`Ca ${shift.ten}`}</span>
                              </label>
                            </Tooltip>
                          </td>
                        ))
                      ) : (
                        <></>
                      )}
                      <td className='border border-gray-500'>
                        <label className='flex items-center justify-center cursor-pointer'>
                          <input
                            type='radio'
                            checked={shiftCheck[rowIndex][shifts.length]}
                            onChange={() =>
                              handleChangeShift('', rowIndex, shifts.length)
                            }
                          />
                          <span className='ml-2'>Nghỉ</span>
                        </label>
                      </td>
                    </tr>
                  ))
                ) : (
                  <></>
                )}
              </tbody>
            </table>
          </div>
          <div className='btn-ctn flex justify-center'>
            <Link
              to={back}
              className='inline-block px-2 py-0.5 border-2 border-green-200 hover:border-green-400 hover:bg-gray-100 hover:text-gray-800 rounded-lg'
            >
              Quay lại
            </Link>
            <button
              type='submit'
              className='inline-block ml-24 px-5 py-0.5 bg-red-400 hover:bg-red-600 text-white rounded-lg'
            >
              Lưu
            </button>
          </div>
        </form>
      </div>
    </div>
  );
};

export default StaffDetail;
