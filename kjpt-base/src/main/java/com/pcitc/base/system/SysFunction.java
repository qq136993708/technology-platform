package com.pcitc.base.system;

import java.io.Serializable;

import com.pcitc.base.util.SearchInfo;

public class SysFunction extends SearchInfo implements Serializable {
    private String id;

    private String name;

    private String parentId;

    private Byte isparent;

    // 图片路径
    private String image;

    // 功能url
    private String url;

    // 排序号
    private Integer weight;

    // 菜单类型：0菜单 1按钮
    private Byte type;

    // 菜单编码
    private String code;

    // 菜单描述
    private String remark;
    
    //启用状态
    private int status;
    
    //是否叶子
    private Integer isLeaf;
    
    private Integer levelCode;
    
    private String parentCode;
    
    //功能图标
    private String icon;
    
    private String functionProperty;	// 有哪些数据控制项
    
    //父节点名称
    private String parentName;
    
    private String functionButtons;
    
    private String parentIndex;		//模糊匹配父亲节点
    
    private String codeIndex;       //模糊匹配当前节点
    
    
    
    public String getParentIndex() {
		return parentIndex;
	}

	public void setParentIndex(String parentIndex) {
		this.parentIndex = parentIndex;
	}

	public String getCodeIndex() {
		return codeIndex;
	}

	public void setCodeIndex(String codeIndex) {
		this.codeIndex = codeIndex;
	}

	public String getFunctionButtons() {
		return functionButtons;
	}

	public void setFunctionButtons(String functionButtons) {
		this.functionButtons = functionButtons;
	}

	private static final long serialVersionUID = 1L;

    public String getFunctionProperty() {
		return functionProperty;
	}

	public void setFunctionProperty(String functionProperty) {
		this.functionProperty = functionProperty;
	}

	public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId == null ? null : parentId.trim();
    }

    public Byte getIsparent() {
        return isparent;
    }

    public void setIsparent(Byte isparent) {
        this.isparent = isparent;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image == null ? null : image.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
    
    public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
	public Integer getIsLeaf() {
		return isLeaf;
	}

	public void setIsLeaf(Integer isLeaf) {
		this.isLeaf = isLeaf;
	}

	public Integer getLevelCode() {
		return levelCode;
	}

	public void setLevelCode(Integer levelCode) {
		this.levelCode = levelCode;
	}
	
	public String getParentCode() {
		return parentCode;
	}

	public void setParentCode(String parentCode) {
		this.parentCode = parentCode;
	}

	
	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getParentName() {
		return parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}

	@Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", parentId=").append(parentId);
        sb.append(", isparent=").append(isparent);
        sb.append(", image=").append(image);
        sb.append(", url=").append(url);
        sb.append(", weight=").append(weight);
        sb.append(", type=").append(type);
        sb.append(", code=").append(code);
        sb.append(", remark=").append(remark);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();

    }
}
