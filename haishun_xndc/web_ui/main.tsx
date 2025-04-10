import { Spin } from "antd";
import { FC } from "react";
import classNames from "classnames";
import ModuleLayout from "./components";
import { useFgLoading } from "./hooks";
import styles from "./index.module.css";

const MainLayout: FC = () => {
  const loadStatus = useFgLoading();
  return (
    <>
      <Spin spinning={loadStatus} wrapperClassName={classNames(styles.spin)}>
        <ModuleLayout />
      </Spin>
    </>
  );
};

export default MainLayout;
