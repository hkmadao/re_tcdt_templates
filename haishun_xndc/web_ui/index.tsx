import { FC } from 'react';
import { Provider } from 'react-redux';
import store from './store';
import MainLayout from './main';
import page from '@/decorator/page';

const Module: FC = () => {
  return (
    <>
      <Provider store={store}>
        <MainLayout />
      </Provider>
    </>
  );
};

export default page()(Module);
