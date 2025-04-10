{%- if not rootInfo.fgMain %}
package {{ rootInfo.mainEntityInfo.basePath }}.{{ rootInfo.mainEntityInfo.packageName }}.dto.vo;
{%- endif %}
{%- if rootInfo.fgMain %}
package {{ rootInfo.basePath }}.{{ rootInfo.packageName}}.dto.vo;
{%- endif %}

import java.util.List;
import java.math.BigDecimal;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.Timestamp;
import java.sql.Date;
import java.sql.Time;
import com.cft.mdc.base.BaseEntity;
import com.cft.mdc.base.DtoIdentify;
import com.cft.mdc.base.DtoIgnoreProperty;
{%- for upAttributeInfo in rootInfo.upAttributeInfoList %}
    {%- if upAttributeInfo.camelCaseName is matching("createUser") %}
import {{ upAttributeInfo.outEntityInfo.basePath }}.{{ upAttributeInfo.outEntityInfo.packageName}}.dto.vo.{{ upAttributeInfo.outEntityInfo.className}}VO;
    {%- endif %}
{%- endfor %}
{%- for outBasePackage in rootInfo.outBasePackageList %}
import {{ outBasePackage.objectTypePackage }}.{{ outBasePackage.objectType }};
{%- endfor %}

public class {{ rootInfo.className }}VO extends BaseEntity {

    /**
     * {{ rootInfo.pkAttributeInfo.displayName }}{%- if rootInfo.pkAttributeInfo.note %}:{{ rootInfo.pkAttributeInfo.note }}{%- else %}{%- endif %}
     */
    @DtoIdentify
    private {{ rootInfo.pkAttributeInfo.objectType }} {{ rootInfo.pkAttributeInfo.attributeName }};

{%- for attributeInfo in rootInfo.baseAttributeInfoList %}
    /**
     * {{ attributeInfo.displayName }}{%- if attributeInfo.note %}:{{ attributeInfo.note }}{%- else %}{%- endif %}
     */
    private {{ attributeInfo.objectType }} {{ attributeInfo.camelCaseName }};
{%- endfor %}

{%- for attributeInfo in rootInfo.fkAttributeInfoList %}
    /**
     * {{ attributeInfo.displayName }}{%- if attributeInfo.note %}:{{ attributeInfo.note }}{%- else %}{%- endif %}
     */
    private {{ attributeInfo.objectType }} {{ attributeInfo.camelCaseName }};
{%- endfor %}

{%- for attributeInfo in rootInfo.upAttributeInfoList %}
    /**
     * {{ attributeInfo.displayName }}{%- if attributeInfo.note %}:{{ attributeInfo.note }}{%- else %}{%- endif %}
     */
    private {{ attributeInfo.objectType }}VO {{ attributeInfo.camelCaseName }};
{%- endfor %}

{%- for attributeInfo in rootInfo.upSingleAttributeInfoList %}
    /**
     * {{ attributeInfo.displayName }}{%- if attributeInfo.note %}:{{ attributeInfo.note }}{%- else %}{%- endif %}
     */
    private {{ attributeInfo.objectType }}VO {{ attributeInfo.camelCaseName }};
{%- endfor %}

    public {{ rootInfo.pkAttributeInfo.objectType }} get{{ rootInfo.pkAttributeInfo.pascalCaseName }}() {
        return {{ rootInfo.pkAttributeInfo.attributeName }};
    }

    public void set{{ rootInfo.pkAttributeInfo.pascalCaseName }}({{ rootInfo.pkAttributeInfo.objectType }} {{ rootInfo.pkAttributeInfo.attributeName }}) {
        this.{{ rootInfo.pkAttributeInfo.attributeName }} = {{ rootInfo.pkAttributeInfo.attributeName }};
    }

{%- for attributeInfo in rootInfo.baseAttributeInfoList %}
    public {{ attributeInfo.objectType }} get{{ attributeInfo.pascalCaseName }}() {
        return {{ attributeInfo.camelCaseName }};
    }

    public void set{{ attributeInfo.pascalCaseName }}({{ attributeInfo.objectType }} {{ attributeInfo.camelCaseName }}) {
        this.{{ attributeInfo.camelCaseName }} = {{ attributeInfo.camelCaseName }};
    }
{%- endfor %}

{%- for attributeInfo in rootInfo.fkAttributeInfoList %}
    public {{ attributeInfo.objectType }} get{{ attributeInfo.pascalCaseName }}() {
        return {{ attributeInfo.camelCaseName }};
    }

    public void set{{ attributeInfo.pascalCaseName }}({{ attributeInfo.objectType }} {{ attributeInfo.camelCaseName }}) {
        this.{{ attributeInfo.camelCaseName }} = {{ attributeInfo.camelCaseName }};
    }
{%- endfor %}

{%- for attributeInfo in rootInfo.upAttributeInfoList %}
    public {{ attributeInfo.objectType }}VO get{{ attributeInfo.pascalCaseName }}() {
        return {{ attributeInfo.camelCaseName }};
    }

    public void set{{ attributeInfo.pascalCaseName }}({{ attributeInfo.objectType }}VO {{ attributeInfo.camelCaseName }}) {
        this.{{ attributeInfo.camelCaseName }} = {{ attributeInfo.camelCaseName }};
    }
{%- endfor %}

{%- for attributeInfo in rootInfo.upSingleAttributeInfoList %}
    public {{ attributeInfo.objectType }}VO get{{ attributeInfo.pascalCaseName }}() {
        return {{ attributeInfo.camelCaseName }};
    }

    public void set{{ attributeInfo.pascalCaseName }}({{ attributeInfo.objectType }}VO {{ attributeInfo.camelCaseName }}) {
        this.{{ attributeInfo.camelCaseName }} = {{ attributeInfo.camelCaseName }};
    }
{%- endfor %}

}
